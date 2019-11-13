package com.wm.gameplat.core.service.impl;

import com.github.pagehelper.PageInfo;
import com.wm.gameplat.core.domain.ExtendLoginInfo;
import com.wm.gameplat.core.mapper.ExtendLoginMapper;
import com.wm.gameplat.core.service.ExtendLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author zi
* @description 推广注册表（tab_extend_login） 接口实现
* @date 2019-11-13
*/
@Service
public class ExtendLoginServiceImpl implements ExtendLoginService {

    @Autowired
    private ExtendLoginMapper extendLoginMapper;

    @Override
    public PageInfo<ExtendLoginInfo> findPage(int pageNum, int pageSize, Map<String, Object> params) {
        return null;
    }



    /**
     * 查询推广注册信息表
     *
     * @param  extendLogin	查询推广注册信息
     * @return 推广注册信息
     */
    @Override
    public List<ExtendLoginInfo> selectExtendLoginList(ExtendLoginInfo extendLogin) {
        Map<String, Object> params = new HashMap<>();
        return extendLoginMapper.selectExtendLoginList(params);
    }
    /**
     * 查询推广注册信息表
     *
     * @param  extendLogin	查询推广注册信息
     * @return 推广注册信息
     */
    @Override
    public int updateExtendLogin(ExtendLoginInfo extendLogin) {
        return extendLoginMapper.updateExtendLogin(extendLogin);
    }










    @Override
    public List<ExtendLoginInfo> findByExample(ExtendLoginInfo extendLogin) {
        return null;
    }

    @Override
    public int countByParams(Map<String, Object> params) {
        return 0;
    }

    @Override
    public ExtendLoginInfo get(Long id) {
        return null;
    }

    /*  @Override
    public PageInfo<TabExtendLogin> findPage(int pageNum, int pageSize, Map<String, Object> params) {
        PageHelper.startPage(pageNum, pageSize);
        List<TabExtendLogin> list = tabExtendLoginDao.findByParams(params);
        return new PageInfo<>(list);
    }

    @Override
    public List<TabExtendLogin> findAll() {
        Map<String, Object> params = new HashMap<>();
        return tabExtendLoginDao.findByParams(params);
    }

    @Override
    public List<TabExtendLogin> findByExample(TabExtendLogin tabExtendLogin) {
        return tabExtendLoginDao.findByExample(tabExtendLogin);
    }

    @Override
    public int countByParams(Map<String, Object> params){
        return tabExtendLoginDao.countByParams(params);
    }

    @Override
    public TabExtendLogin get(Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        List<TabExtendLogin> list = tabExtendLoginDao.findByParams(params);
        if(list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
*/

}

