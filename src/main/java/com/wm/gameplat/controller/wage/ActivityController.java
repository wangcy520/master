package com.wm.gameplat.controller.wage;


import com.wm.gameplat.core.domain.ActivityInfo;
import com.wm.gameplat.core.service.IActivityService;

import com.wm.gameplat.utils.ResultUtil;
import com.wm.gameplat.vo.Result;
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
    public Result selectActivityList(ActivityInfo activity) {


        return ResultUtil.data(iActivityService.selectActivityList(activity));

    }


}