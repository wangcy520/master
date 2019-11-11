package com.wm.gameplat.controller.wage;


import com.wm.gameplat.core.domain.ActivityInfo;
import com.wm.gameplat.core.service.IActivityService;
import com.wm.gameplat.utils.ResultUtil;
import com.wm.gameplat.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        List<ActivityInfo> collect =iActivityService.selectActivityList(activity);
        List<ActivityInfo> notices =new ArrayList<>();
        List<ActivityInfo>  activitys = new ArrayList<>();
        collect.forEach(item ->{
                if(item.getTypes().equals("0")){
                    notices.add(item);
                }else {
                    activitys.add(item);
                }
        });
        Map<String, List> mmap = new HashMap<>();
        mmap.put("notices",notices);
        mmap.put("activitys",activitys);
        return ResultUtil.data(mmap);
    }

}