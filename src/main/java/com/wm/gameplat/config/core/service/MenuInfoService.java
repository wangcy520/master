package com.wm.gameplat.config.core.service;


import com.github.pagehelper.PageInfo;
import com.wm.gameplat.config.core.domain.MenuInfo;

import java.util.List;
import java.util.Map;

/**
 * @author karl
 * @description 菜单权限表（menu_info） 接口
 * @date 2019-11-07 20:09:04
 */
public interface MenuInfoService {

    PageInfo<MenuInfo> findPage(int pageNum, int pageSize, Map<String, Object> params);

    List<MenuInfo> findAll();

    List<MenuInfo> findByExample(MenuInfo menuInfo);

    int countByParams(Map<String, Object> params);

    MenuInfo get(Long id);

    int save(MenuInfo menuInfo);

    int update(MenuInfo menuInfo);

    List<MenuInfo> findMenuByRole(int... roleIds);
}