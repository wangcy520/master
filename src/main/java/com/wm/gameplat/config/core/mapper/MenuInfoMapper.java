package com.wm.gameplat.config.core.mapper;

import com.wm.gameplat.config.core.domain.MenuInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author karl
 * @description 菜单权限表（menu_info）
 * @date 2019-11-07 20:09:04
 */
@Mapper
public interface MenuInfoMapper {

    MenuInfo findById(Long id);

    List<MenuInfo> findByIds(List<Long> ids);

    List<MenuInfo> findByExample(MenuInfo menuInfo);

    int count(MenuInfo menuInfo);

    List<MenuInfo> findByParams(Map<String, Object> params);

    int countByParams(Map<String, Object> params);

    List<MenuInfo> findAll();

    int save(MenuInfo menuInfo);

    int update(MenuInfo menuInfo);

    int delete(Long id);

    int saveOrUpdate(MenuInfo menuInfo);

    int batchSave(List<MenuInfo> menuInfoList);

    int batchUpdate(List<MenuInfo> menuInfoList);

    int batchDelete(List<Long> ids);

    List<MenuInfo> findMenuByRole(int... ids);
}