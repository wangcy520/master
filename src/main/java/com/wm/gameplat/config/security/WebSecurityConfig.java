package com.wm.gameplat.config.security;

import com.wm.gameplat.config.properties.CaptchaProperties;
import com.wm.gameplat.config.properties.TokenProperties;
import com.wm.gameplat.config.security.jwt.AuthenticationFailHandler;
import com.wm.gameplat.config.security.jwt.AuthenticationSuccessHandler;
import com.wm.gameplat.config.security.jwt.JWTAuthenticationFilter;
import com.wm.gameplat.config.security.jwt.RestAccessDeniedHandler;
import com.wm.gameplat.config.security.permission.MyFilterSecurityInterceptor;
import com.wm.gameplat.config.security.validate.ImageValidateFilter;
import com.wm.gameplat.utils.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * Security 核心配置类
 * 开启注解控制权限至Controller
 *
 * @author Exrickx
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled =true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenProperties tokenProperties;


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    private AuthenticationFailHandler failHandler;

    @Autowired
    private RestAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Autowired
    private ImageValidateFilter imageValidateFilter;

    @Autowired
    private CaptchaProperties captchaProperties;

    /*@Autowired
    private SmsValidateFilter smsValidateFilter;

    @Autowired
    private VaptchaValidateFilter vaptchaValidateFilter;

    @Autowired
    private EmailValidateFilter emailValidateFilter;*/

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SecurityUtil securityUtil;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .authorizeRequests();
        // 除配置文件忽略路径其它所有请求都需经过认证和授权
        for (String url : captchaProperties.getIgnored()) {
            registry.antMatchers(url).permitAll();
        }

        registry.and()
                // 表单登录方式
                .formLogin()
                .loginPage("/usercenter/needLogin")
                // 登录请求url
                .loginProcessingUrl("/usercenter/login")
                .permitAll()
                // 成功处理类
                .successHandler(successHandler)
                // 失败
                .failureHandler(failHandler)
                .and()
                // 允许网页iframe
                .headers().frameOptions().disable()
                .and()
                .logout()
                .permitAll()
                .and()
                .authorizeRequests()
                // 任何请求
                .anyRequest()
                // 需要身份认证
                .authenticated()
                .and()
                //  允许跨域
                .cors().disable()
                // 关闭跨站请求防护
                .csrf().disable()
                // 前后端分离采用JWT 不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 自定义权限拒绝处理类
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .and()
                // 图形验证码过滤器
                .addFilterBefore(imageValidateFilter, UsernamePasswordAuthenticationFilter.class)
                // 短信验证码过滤器
                /* .addFilterBefore(smsValidateFilter, UsernamePasswordAuthenticationFilter.class)
                 // vaptcha验证码过滤器
                 .addFilterBefore(vaptchaValidateFilter, UsernamePasswordAuthenticationFilter.class)
                 // email验证码过滤器
                 .addFilterBefore(emailValidateFilter, UsernamePasswordAuthenticationFilter.class)*/
                // 添加自定义权限过滤器
                .addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)
                // 添加JWT认证过滤器
                .addFilter(new JWTAuthenticationFilter(authenticationManager(), tokenProperties, redisTemplate, securityUtil));
    }
}
