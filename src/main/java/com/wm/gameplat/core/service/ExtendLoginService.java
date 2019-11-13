package com.wm.gameplat.core.service;

import com.github.pagehelper.PageInfo;
import com.wm.gameplat.core.domain.ExtendLoginInfo;

import java.util.List;
import java.util.Map;

/**
* @author zi
* @description 推广注册表（tab_extend_login） 接口
* @date 2019-11-13
*/
public interface ExtendLoginService {

    /**
     * 查询推广注册信息表
     *
     * @param  extendLogin	查询推广注册信息
     * @return 推广注册信息
     */
    List<ExtendLoginInfo> selectExtendLoginList(ExtendLoginInfo extendLogin);


    /**
     * 修改推广注册信息表
     *
     * @param  extendLogin	修改推广注册信息
     * @return 推广注册信息
     */
    int updateExtendLogin(ExtendLoginInfo extendLogin);












    PageInfo<ExtendLoginInfo> findPage(int pageNum, int pageSize, Map<String, Object> params);



    List<ExtendLoginInfo> findByExample(ExtendLoginInfo extendLogin);

    int countByParams(Map<String, Object> params);

    ExtendLoginInfo get(Long id);
/*
    int save(ExtendLoginInfo extendLogin);

    int update(ExtendLoginInfo extendLogin);*/
}