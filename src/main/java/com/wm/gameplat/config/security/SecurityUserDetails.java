package com.wm.gameplat.config.security;

import com.wm.gameplat.constant.CommonConstant;
import com.wm.gameplat.core.domain.MenuInfo;
import com.wm.gameplat.core.domain.RoleInfo;
import com.wm.gameplat.core.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Exrickx
 */
@Slf4j
public class SecurityUserDetails extends UserInfo implements UserDetails {

    private static final long serialVersionUID = 1L;

    public SecurityUserDetails(UserInfo user) {

        if (user != null) {
            this.setUsername(user.getUsername());
            this.setPassword(user.getPassword());
            this.setStatus(user.getStatus());
            this.setRoleList(user.getRoleList());
            this.setAuthorityList(user.getAuthorityList());
        }
    }

    /**
     * 添加用户拥有的权限和角色
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorityList = new ArrayList<>();
        List<MenuInfo> permissions = this.getAuthorityList();
        // 添加请求权限
        if (permissions != null && permissions.size() > 0) {
            for (MenuInfo permission : permissions) {
                if (StringUtils.isNotBlank(permission.getTitle()) &&
                        StringUtils.isNotBlank(permission.getPath())) {

                    authorityList.add(new SimpleGrantedAuthority(permission.getTitle()));
                }
            }
        }
        // 添加角色
        List<RoleInfo> roles = this.getRoleList();
        if (roles != null && roles.size() > 0) {
            // lambda表达式
            roles.forEach(item -> {
                if (StringUtils.isNotBlank(item.getRoleKey())) {
                    authorityList.add(new SimpleGrantedAuthority(item.getRoleKey()));
                }
            });
        }
        return authorityList;
    }


    /**
     * 账户是否过期
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    /**
     * 是否禁用
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return !CommonConstant.USER_STATUS_LOCK.equals(this.getStatus());
    }

    /**
     * 密码是否过期
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    /**
     * 是否启用
     *
     * @return
     */
    @Override
    public boolean isEnabled() {

        return !CommonConstant.USER_STATUS_NORMAL.toString().equals(this.getStatus());
    }

}