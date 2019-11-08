package com.wm.gameplat.controller.usercenter.controller;


import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wm.gameplat.utils.ResultUtil;
import com.wm.gameplat.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 会员控制类
 *
 * @author
 */
@RestController
@RequestMapping(value = "/usercenter")
public class UserController {

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
    public JSONObject swaggerLogin(@RequestParam String username, @RequestParam String password,
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

}
