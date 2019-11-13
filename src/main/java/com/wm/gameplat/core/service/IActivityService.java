package com.wm.gameplat.core.service;


import com.wm.gameplat.core.domain.ActivityInfo;

import java.util.List;

/**
 * 标签活动信息 服务层
 */
public interface IActivityService {

    /**
     * 查询标签活动信息表
     *
     * @param  activityInfo 查询标签活动信息
     * @return 标签活动信息
     */
    public List<ActivityInfo> selectActivityList(ActivityInfo activityInfo);


    /**
     * 新增标签活动信息表
     *
     * @param activity 新增标签活动信息
     * @return 标签活动信息
     */
    public int insertActivity(ActivityInfo activity);

}