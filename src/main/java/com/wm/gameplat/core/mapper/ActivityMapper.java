package com.wm.gameplat.core.mapper;


import com.wm.gameplat.core.domain.ActivityInfo;

import java.util.List;

/**
 * 标签活动信息 数据层
 */
public interface ActivityMapper {



    /**
     * 查询标签活动信息
     *
     * @param  activity 查询标签活动信息
     * @return 标签活动信息
     */
    public List<ActivityInfo> selectActivityList(ActivityInfo activity);



    /**
     * 新增标签活动信息
     *
     * @param activity 新增标签活动信息
     * @return 标签活动信息
     */

    public int insertActivity(ActivityInfo activity);


}