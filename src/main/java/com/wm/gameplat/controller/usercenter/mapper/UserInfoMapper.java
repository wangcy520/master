package com.wm.gameplat.controller.usercenter.mapper;

import com.wm.gameplat.controller.usercenter.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author karl
 * @description （user_info）
 * @date 2019-11-07 20:09:05
 */
@Repository
public interface UserInfoMapper {

    UserInfo findById(Long id);

    List<UserInfo> findByIds(List<Long> ids);

    List<UserInfo> findByExample(UserInfo userInfo);

    int count(UserInfo userInfo);

    List<UserInfo> findByParams(Map<String, Object> params);

    int countByParams(Map<String, Object> params);

    List<UserInfo> findAll();

    int save(UserInfo userInfo);

    int update(UserInfo userInfo);

    int delete(Long id);

    int saveOrUpdate(UserInfo userInfo);

    int batchSave(List<UserInfo> userInfoList);

    int batchUpdate(List<UserInfo> userInfoList);

    int batchDelete(List<Long> ids);

    UserInfo findByUsername(String userName);

    UserInfo findByMobile(String mobile);
}