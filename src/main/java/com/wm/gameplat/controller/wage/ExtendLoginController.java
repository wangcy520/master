package com.wm.gameplat.controller.wage;


import com.wm.gameplat.core.domain.ExtendLoginInfo;
import com.wm.gameplat.core.service.ExtendLoginService;
import com.wm.gameplat.utils.ResultUtil;
import com.wm.gameplat.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 推广注册表
 */

@RestController
@RequestMapping("/system/ExtendLogin")
public class ExtendLoginController {

    @Autowired
    private ExtendLoginService extendLoginService;

    /**
     * 查询推广注册表
     */
    @GetMapping("/list")
    @ResponseBody
    public Result selectExtendLoginList(ExtendLoginInfo extendLogin) {
        return ResultUtil.data(extendLoginService.selectExtendLoginList(extendLogin));
    }



}
