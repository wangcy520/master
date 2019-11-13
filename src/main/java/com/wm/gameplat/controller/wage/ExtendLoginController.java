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
     * @param extendLogin
     */
    @GetMapping("/list")
    @ResponseBody
    public Result selectExtendLoginList(ExtendLoginInfo extendLogin) {
        return ResultUtil.data(extendLoginService.selectExtendLoginList(extendLogin));
    }

    /**
     * 修改推广注册表
     * @param extendLogin
     */
    @PostMapping(value = "/edit")
    public Result updateExtendLogin(ExtendLoginInfo extendLogin){
       /* if(null == gm.getId()||"".equals(gm.getId())){
            return error("ID必传");
        }
        System.out.println(gm.toString());*/
        return ResultUtil.data(extendLoginService.updateExtendLogin(extendLogin));
    }

}
