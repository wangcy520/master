package com.wm.gameplat.config.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.gameplat.config.core.domain.MenuInfo;
import com.wm.gameplat.config.core.mapper.MenuInfoMapper;
import com.wm.gameplat.config.core.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author karl
 * @description 菜单权限表（menu_info） 接口实现
 * @date 2019-11-07 20:09:04
 */
@Service
public class MenuInfoServiceImpl implements MenuInfoService {

    @Autowired
    private MenuInfoMapper menuInfoMapper;

    @Override
    public PageInfo<MenuInfo> findPage(int pageNum, int pageSize, Map<String, Object> params) {
        PageHelper.startPage(pageNum, pageSize);
        List<MenuInfo> list = menuInfoMapper.findByParams(params);
        return new PageInfo<>(list);
    }

    @Override
    public List<MenuInfo> findAll() {
        Map<String, Object> params = new HashMap<>();
        return menuInfoMapper.findByParams(params);
    }

    @Override
    public List<MenuInfo> findByExample(MenuInfo menuInfo) {
        return menuInfoMapper.findByExample(menuInfo);
    }

    @Override
    public int countByParams(Map<String, Object> params) {
        return menuInfoMapper.countByParams(params);
    }

    @Override
    public MenuInfo get(Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        List<MenuInfo> list = menuInfoMapper.findByParams(params);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int save(MenuInfo menuInfo) {
        return menuInfoMapper.save(menuInfo);
    }

    @Override
    public int update(MenuInfo menuInfo) {
        return menuInfoMapper.update(menuInfo);
    }

    @Override
    public List<MenuInfo> findMenuByRole(int... roleIds) {
        /*hellokt*/
        return menuInfoMapper.findMenuByRole(roleIds);
    }
}

