package com.wm.gameplat.config.security.jwt;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wm.gameplat.config.properties.TokenProperties;
import com.wm.gameplat.constant.SecurityConstant;
import com.wm.gameplat.utils.ResponseUtil;
import com.wm.gameplat.utils.SecurityUtil;
import com.wm.gameplat.vo.TokenUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {


    private TokenProperties tokenProperties;

    private StringRedisTemplate redisTemplate;

    private SecurityUtil securityUtil;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, TokenProperties tokenProperties, StringRedisTemplate redisTemplate, SecurityUtil securityUtil) {
        super(authenticationManager);
        this.tokenProperties = tokenProperties;
        this.redisTemplate = redisTemplate;
        this.securityUtil = securityUtil;
    }

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader(SecurityConstant.HEADER);
        if (StringUtils.isBlank(header)) {
            header = request.getParameter(SecurityConstant.HEADER);
        }
        boolean notValid = StringUtils.isBlank(header) || (!tokenProperties.getRedis() && !header.startsWith(SecurityConstant.TOKEN_SPLIT));
        if (notValid) {
            chain.doFilter(request, response);
            return;
        }
        try {
            UsernamePasswordAuthenticationToken authentication = getAuthentication(header, response);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception ignored) {

        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String header, HttpServletResponse response) {

        // 用户名
        String username = null;
        // 权限
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (tokenProperties.getRedis()) {
            // redis
            String v = redisTemplate.opsForValue().get(SecurityConstant.TOKEN_PRE + header);
            if (StringUtils.isBlank(v)) {
                ResponseUtil.out(response, ResponseUtil.resultMap(false, 401, "登录已失效，请重新登录"));
                return null;
            }
            TokenUser user = new Gson().fromJson(v, TokenUser.class);
            username = user.getUsername();
            if (tokenProperties.getStorePerms()) {
                // 缓存了权限
                for (String ga : user.getPermissions()) {
                    authorities.add(new SimpleGrantedAuthority(ga));
                }
            } else {
                // 未缓存 读取权限数据
                authorities = securityUtil.getCurrUserPerms(username);
            }
            if (!user.getSaveLogin()) {
                // 若未保存登录状态重新设置失效时间
                redisTemplate.opsForValue().set(SecurityConstant.USER_TOKEN + username, header, tokenProperties.getTokenExpireTime(), TimeUnit.MINUTES);
                redisTemplate.opsForValue().set(SecurityConstant.TOKEN_PRE + header, v, tokenProperties.getTokenExpireTime(), TimeUnit.MINUTES);
            }
        } else {
            // JWT
            try {
                // 解析token
                Claims claims = Jwts.parser()
                        .setSigningKey(SecurityConstant.JWT_SIGN_KEY)
                        .parseClaimsJws(header.replace(SecurityConstant.TOKEN_SPLIT, ""))
                        .getBody();

                // 获取用户名
                username = claims.getSubject();
                // 获取权限
                if (tokenProperties.getStorePerms()) {
                    // 缓存了权限
                    String authority = claims.get(SecurityConstant.AUTHORITIES).toString();
                    if (StringUtils.isNotBlank(authority)) {
                        List<String> list = new Gson().fromJson(authority, new TypeToken<List<String>>() {
                        }.getType());
                        for (String ga : list) {
                            authorities.add(new SimpleGrantedAuthority(ga));
                        }
                    }
                } else {
                    // 未缓存 读取权限数据
                    authorities = securityUtil.getCurrUserPerms(username);
                }
            } catch (ExpiredJwtException e) {
                ResponseUtil.out(response, ResponseUtil.resultMap(false, 401, "登录已失效，请重新登录"));
            } catch (Exception e) {
                log.error(e.toString());
                ResponseUtil.out(response, ResponseUtil.resultMap(false, 500, "解析token错误"));
            }
        }

        if (StringUtils.isNotBlank(username)) {
            // 踩坑提醒 此处password不能为null
            User principal = new User(username, "", authorities);
            return new UsernamePasswordAuthenticationToken(principal, null, authorities);
        }
        return null;
    }
}