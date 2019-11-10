package com.wm.gameplat.config.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.gameplat.config.core.domain.RoleInfo;
import com.wm.gameplat.config.core.domain.UserInfo;
import com.wm.gameplat.config.core.mapper.UserInfoMapper;
import com.wm.gameplat.config.core.service.MenuInfoService;
import com.wm.gameplat.config.core.service.RoleInfoService;
import com.wm.gameplat.config.core.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author karl
 * @description （user_info） 接口实现
 * @date 2019-11-06 19:41:13
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private MenuInfoService menuInfoService;

    @Override
    public PageInfo<UserInfo> findPage(int pageNum, int pageSize, Map<String, Object> params) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> list = userInfoMapper.findByParams(params);
        return new PageInfo<>(list);
    }

    @Override
    public List<UserInfo> findAll() {
        Map<String, Object> params = new HashMap<>();
        return userInfoMapper.findByParams(params);
    }

    @Override
    public List<UserInfo> findByExample(UserInfo userInfo) {
        return userInfoMapper.findByExample(userInfo);
    }

    @Override
    public int countByParams(Map<String, Object> params) {
        return userInfoMapper.countByParams(params);
    }

    @Override
    public UserInfo get(Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        List<UserInfo> list = userInfoMapper.findByParams(params);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public UserInfo findByUsername(String userName) {

        UserInfo userInfo = userInfoMapper.findByUsername(userName);

        if (userInfo != null) {
            List<RoleInfo> roleByUser = roleInfoService.findRoleByUser(userInfo.getId());
            userInfo.setRoleList(roleByUser);
            if (!CollectionUtils.isEmpty(roleByUser)) {
                int[] ints = roleByUser.stream().mapToInt(RoleInfo::getRoleId).distinct().toArray();
                userInfo.setAuthorityList(menuInfoService.findMenuByRole(ints));
            }
            return userInfo;
        }
        return null;
    }

    @Override
    public UserInfo findByMobile(String mobile) {

        return  userInfoMapper.findByMobile(mobile);
    }
}

