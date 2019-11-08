package com.wm.gameplat.controller.usercenter.mapper;

import com.wm.gameplat.controller.usercenter.domain.RoleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author karl
 * @description （role_info）
 * @date 2019-11-07 20:09:04
 */
@Mapper
public interface RoleInfoMapper {

    RoleInfo findById(Long id);

    List<RoleInfo> findByIds(List<Long> ids);

    List<RoleInfo> findByExample(RoleInfo roleInfo);

    int count(RoleInfo roleInfo);

    List<RoleInfo> findByParams(Map<String, Object> params);

    int countByParams(Map<String, Object> params);

    List<RoleInfo> findAll();

    int save(RoleInfo roleInfo);

    int update(RoleInfo roleInfo);

    int delete(Long id);

    int saveOrUpdate(RoleInfo roleInfo);

    int batchSave(List<RoleInfo> roleInfoList);

    int batchUpdate(List<RoleInfo> roleInfoList);

    int batchDelete(List<Long> ids);

    List<RoleInfo> findRoleByUser(Integer userId);
}