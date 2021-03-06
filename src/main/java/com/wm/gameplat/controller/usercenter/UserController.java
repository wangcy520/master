package com.wm.gameplat.controller.usercenter;


import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wm.gameplat.config.exception.RunningException;
import com.wm.gameplat.core.domain.UserInfo;
import com.wm.gameplat.core.service.UserInfoService;
import com.wm.gameplat.utils.ResultUtil;
import com.wm.gameplat.utils.SecurityUtil;
import com.wm.gameplat.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 会员控制类
 *
 * @author
 */
@RestController
@RequestMapping(value = "/userCenter")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SecurityUtil securityUtil;
    /**
     * 判断会员是否已登录
     *
     * @return
     */
    @GetMapping("/checklogin")
    public String checkLogin() {
        return "aaaaaa";
    }

    @RequestMapping(value = "/needLogin", method = RequestMethod.GET)
    public Result<Object> needLogin(){

        return new ResultUtil<Object>().setErrorMsg(401, "您还未登录");
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public JSONObject login(@RequestParam String username, @RequestParam String password,
                                   @RequestParam(required = false) String code,
                                   @RequestParam(required = false) String captchaId,
                                   @RequestParam(required = false, defaultValue = "http://127.0.0.1:8080/usercenter/login")
                                               String loginUrl){

        Map<String, Object> params = new HashMap<>(16);
        params.put("username", username);
        params.put("password", password);
        params.put("code", code);
        params.put("captchaId", captchaId);
        String result = HttpUtil.post(loginUrl, params);
        return JSON.parseObject(result);
    }

    @RequestMapping(value = "/smsLogin", method = RequestMethod.POST)
    public Result smsLogin(@RequestParam String mobile, @RequestParam String code){
        UserInfo byMobile = userInfoService.findByMobile(mobile);
        if (null ==byMobile){
            throw new RunningException("手机号不存在");
        }
        String token = securityUtil.getToken(byMobile.getUsername(), false);
        return ResultUtil.success(token);
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public Result userInfo(){
        UserInfo currUser = securityUtil.getCurrUser();
        return ResultUtil.data(currUser);
    }


    @GetMapping(value = "/getTest")
    public void getTest(@Validated UserInfo userInfo){
        System.out.println("aaaaaaaaaaaa");





    }



}
