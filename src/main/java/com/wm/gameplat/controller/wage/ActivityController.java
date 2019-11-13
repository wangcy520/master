package com.wm.gameplat.controller.wage;


import com.wm.gameplat.core.domain.ActivityInfo;
import com.wm.gameplat.core.service.IActivityService;
import com.wm.gameplat.utils.ResultUtil;
import com.wm.gameplat.utils.StringUtils;
import com.wm.gameplat.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 标签活动信息表
 */

@RestController
@RequestMapping("/system/Activity")
public class ActivityController {

    @Autowired
    private  IActivityService iActivityService;

    /**
     * 查询标签活动信息表
     */
    @GetMapping("/list")
    @ResponseBody
    public Result selectActivityList(ActivityInfo activity) {
        List<ActivityInfo> activityInfoList = iActivityService.selectActivityList(activity);
        Map<String, List<ActivityInfo>> collect = activityInfoList.stream().collect(Collectors.groupingBy(ActivityInfo::getTypes));
        Map<String, List> map = new HashMap<>();
        collect.forEach((key, val) -> {
            if ("0".equals(key)) {
                map.put("notices", val);
            } else {
                map.put("activity", val);
            }
        });
        return ResultUtil.data(map);
    }


    /**
     * 新增标签活动信息表
     */

    @PostMapping("/add")
    @ResponseBody
    public Result addActivity(ActivityInfo activity) {

        return ResultUtil.data(iActivityService.insertActivity(activity));
    }

}
