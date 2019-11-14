package com.wm.gameplat.controller.wage;


import com.wm.gameplat.core.domain.ExtendLoginInfo;
import com.wm.gameplat.core.service.ExtendLoginService;
import com.wm.gameplat.utils.CreateVerifyCode;
import com.wm.gameplat.utils.QRCodeUtil;
import com.wm.gameplat.utils.ResultUtil;
import com.wm.gameplat.utils.StringUtils;
import com.wm.gameplat.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.wm.gameplat.utils.ResultUtil.error;


/**
 * 推广注册表
 */

@RestController
@RequestMapping("/system/extendLogin")
public class ExtendLoginController {

    @Autowired
    private ExtendLoginService extendLoginService;


    /**
     * 查询推广注册表
     *
     * @param extendLogin
     */
    @GetMapping("/list")
    @ResponseBody
    public Result selectExtendLoginList(ExtendLoginInfo extendLogin) {
        return ResultUtil.data(extendLoginService.selectExtendLoginList(extendLogin));
    }

    /**
     * 修改推广注册表
     *
     * @param extendLogin
     */
    @PostMapping(value = "/edit")
    public Result updateExtendLogin(ExtendLoginInfo extendLogin) {
        //用户ID不可为空
        if (null == extendLogin.getUserId()) {
            return error();
        }
        return ResultUtil.data(extendLoginService.updateExtendLogin(extendLogin));
    }


    /**
     * 新增推广注册表
     *
     * @param extendLogin
     */
    @PostMapping(value = "/add")
    public Result addExtendLogin(ExtendLoginInfo extendLogin) {
        //调取二维码
        QRCodeUtil.createQRCode();
        //获取推广网页地址
        extendLogin.setExtendHtml("http://baidu.com");
        //是否生成10位推广码
        extendLogin.setExtendCode(StringUtils.isEmpty(extendLogin.getExtendCode()) ? CreateVerifyCode.randomStr(10) : extendLogin.getExtendCode());
        return ResultUtil.data(extendLoginService.addExtendLogin(extendLogin));
    }

}