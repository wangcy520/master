package com.wm.gameplat.core.service.impl;


import com.wm.gameplat.core.domain.ActivityInfo;
import com.wm.gameplat.core.mapper.ActivityMapper;
import com.wm.gameplat.core.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询标签活动信息 服务层实现
 *
 * @date 2019-11-10
 */
@Service
public class ActivityServiceImpl implements IActivityService {

    @Autowired
    private ActivityMapper activityMapper;
    /**
     * 查询标签活动信息表
     *
     * @param  activityInfo 查询标签活动信息
     * @return 标签活动信息
     */
    @Override
    public List<ActivityInfo> selectActivityList(ActivityInfo activityInfo) {
        return activityMapper.selectActivityList(activityInfo);
    }






}
