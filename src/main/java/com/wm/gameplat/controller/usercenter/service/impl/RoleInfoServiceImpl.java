package com.wm.gameplat.controller.usercenter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.gameplat.controller.usercenter.domain.RoleInfo;
import com.wm.gameplat.controller.usercenter.mapper.RoleInfoMapper;
import com.wm.gameplat.controller.usercenter.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author karl
 * @description （role_info） 接口实现
 * @date 2019-11-07 20:09:04
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public PageInfo<RoleInfo> findPage(int pageNum, int pageSize, Map<String, Object> params) {
        PageHelper.startPage(pageNum, pageSize);
        List<RoleInfo> list = roleInfoMapper.findByParams(params);
        return new PageInfo<>(list);
    }

    @Override
    public List<RoleInfo> findAll() {
        Map<String, Object> params = new HashMap<>();
        return roleInfoMapper.findByParams(params);
    }

    @Override
    public List<RoleInfo> findByExample(RoleInfo roleInfo) {
        return roleInfoMapper.findByExample(roleInfo);
    }

    @Override
    public int countByParams(Map<String, Object> params) {
        return roleInfoMapper.countByParams(params);
    }

    @Override
    public RoleInfo get(Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        List<RoleInfo> list = roleInfoMapper.findByParams(params);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int save(RoleInfo roleInfo) {
        return roleInfoMapper.save(roleInfo);
    }

    @Override
    public int update(RoleInfo roleInfo) {
        return roleInfoMapper.update(roleInfo);
    }

    @Override
    public List<RoleInfo> findRoleByUser(Integer userId) {
        return roleInfoMapper.findRoleByUser(userId);
    }
}

