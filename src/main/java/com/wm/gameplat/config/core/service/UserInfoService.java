package com.wm.gameplat.config.core.service;

import com.github.pagehelper.PageInfo;
import com.wm.gameplat.config.core.domain.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @author karl
 * @description （user_info） 接口
 * @date 2019-11-06 19:41:13
 */
public interface UserInfoService {

    PageInfo<UserInfo> findPage(int pageNum, int pageSize, Map<String, Object> params);

    List<UserInfo> findAll();

    List<UserInfo> findByExample(UserInfo userInfo);

    int countByParams(Map<String, Object> params);

    UserInfo get(Long id);

    UserInfo findByUsername(String userName);

    UserInfo findByMobile(String mobile);

}