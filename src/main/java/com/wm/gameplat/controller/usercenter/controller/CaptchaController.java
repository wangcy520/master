package com.wm.gameplat.controller.usercenter.controller;


import com.wm.gameplat.utils.CreateVerifyCode;
import com.wm.gameplat.utils.ResultUtil;
import com.wm.gameplat.utils.SmsSample;
import com.wm.gameplat.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RequestMapping("/captcha")
@RestController
public class CaptchaController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SmsSample smsSampleService;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public Result<Object> initCaptcha() {

        String captchaId = UUID.randomUUID().toString().replace("-","");
        String code =  CreateVerifyCode.randomStr(4);
        // 缓存验证码
        redisTemplate.opsForValue().set(captchaId, code,2L, TimeUnit.MINUTES);
        return new ResultUtil<Object>().setData(captchaId);
    }

    @RequestMapping(value = "/draw/{captchaId}", method = RequestMethod.GET)
    public void drawCaptcha(@PathVariable("captchaId") String captchaId,
                            HttpServletResponse response) throws IOException {

        // 得到验证码 生成指定验证码
        String code = redisTemplate.opsForValue().get(captchaId);
        CreateVerifyCode vCode = new CreateVerifyCode(116,36,4,10, code);
        response.setContentType("image/png");
        vCode.write(response.getOutputStream());
    }


    @RequestMapping(value = "/getValidSms", method = RequestMethod.POST)
    public Result getValidSms(@RequestParam("mobile") String mobile, HttpServletRequest request) {
        return smsSampleService.sendMessage(mobile, request);
    }
}
