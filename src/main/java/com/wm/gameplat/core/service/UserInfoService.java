package com.wm.gameplat.core.service;

import com.wm.gameplat.core.domain.UserInfo;

import java.util.List;

/**
* @author zi
* @description 用户基础信息表（user_info） 接口
* @date 2019-11-14
*/
public interface UserInfoService {

    /**
     * 用户新增代理注册
     *
     * @param  userInfo	用户新增代理注册
     * @return 用户新增代理注册
     */
    List<UserInfo> addManageLogin(UserInfo userInfo);


    /**
     * 查询用户列表
     *
     * @param  userInfo	查询用户列表
     * @return 查询用户列表
     */
    List<UserInfo> selectUserList(UserInfo userInfo);

}