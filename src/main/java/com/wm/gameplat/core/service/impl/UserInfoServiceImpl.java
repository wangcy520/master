package com.wm.gameplat.core.service.impl;
import com.wm.gameplat.core.domain.UserInfo;
import com.wm.gameplat.core.mapper.UserInfoMapper;
import com.wm.gameplat.core.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zi
* @description 用户基础信息表（user_info） 接口实现
* @date 2019-11-14
*/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    /**
     * 用户新增代理注册
     *
     * @param  userInfo	用户新增代理注册
     * @return 用户新增代理注册
     */
    @Override
    public List<UserInfo> addManageLogin(UserInfo userInfo) {

        return userInfoMapper.addManageLogin(userInfo);
    }


    /**
     * 查询用户列表
     *
     * @param  userInfo	查询用户列表
     * @return 查询用户列表
     */

    @Override
    public List<UserInfo> selectUserList(UserInfo userInfo) {
        return userInfoMapper.selectUserList(userInfo);
    }
}

