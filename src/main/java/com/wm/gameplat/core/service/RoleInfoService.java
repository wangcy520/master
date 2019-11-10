package com.wm.gameplat.core.service;

import com.github.pagehelper.PageInfo;
import com.wm.gameplat.core.domain.RoleInfo;

import java.util.List;
import java.util.Map;

/**
 * @author karl
 * @description （role_info） 接口
 * @date 2019-11-07 20:09:04
 */
public interface RoleInfoService {

    PageInfo<RoleInfo> findPage(int pageNum, int pageSize, Map<String, Object> params);

    List<RoleInfo> findAll();

    List<RoleInfo> findByExample(RoleInfo roleInfo);

    int countByParams(Map<String, Object> params);

    RoleInfo get(Long id);

    int save(RoleInfo roleInfo);

    int update(RoleInfo roleInfo);

    List<RoleInfo> findRoleByUser(Integer userId);
}