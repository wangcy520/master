package com.wm.gameplat.controller.wage;


import com.wm.gameplat.core.domain.ActivityInfo;
import com.wm.gameplat.core.service.IActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签活动信息表
 */

@RestController
@RequestMapping("/system/Activity")
public class ActivityController {

    @Autowired
    private  IActivityService iActivityService;

    /**
     * 标签活动信息表
     */
    @GetMapping("/list")
    @ResponseBody
    public List<ActivityInfo> selectActivityList(ActivityInfo activity) {


        return iActivityService.selectActivityList(activity);

    }


}