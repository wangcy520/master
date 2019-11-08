package com.wm.gameplat.utils;

import com.wm.gameplat.controller.usercenter.domain.RoleInfo;
import com.wm.gameplat.controller.usercenter.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SecurityUtil {


    @Autowired
    private UserInfoService userInfoService;

    /**
     * 通过用户名获取用户拥有权限
     *
     * @param username
     */
    public List<GrantedAuthority> getCurrUserPerms(String username) {

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleInfo role : userInfoService.findByUsername(username).getRoleList()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleKey()));
        }
        return authorities;
    }


}
