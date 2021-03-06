package com.wm.gameplat.controller.usercenter;


import com.wm.gameplat.utils.CreateVerifyCode;
import com.wm.gameplat.utils.QRCodeUtil;
import com.wm.gameplat.utils.ResultUtil;
import com.wm.gameplat.utils.SmsSample;
import com.wm.gameplat.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
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
        CreateVerifyCode vCode = new CreateVerifyCode(116,36,4,10, code);
        String imageBinary = vCode.getImageBinary();
        return new ResultUtil<Object>().setData(imageBinary,captchaId);
    }

    @RequestMapping(value = "/draw", method = RequestMethod.GET)
    public void drawCaptcha(@RequestParam("captchaId") String captchaId,
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

    @RequestMapping(value = "/createCommonQRCode")
    public void createCommonQRCode(HttpServletResponse response, String url) throws Exception {
        ServletOutputStream stream = null;
        try {
            stream = response.getOutputStream();
            //使用工具类生成二维码
            QRCodeUtil.encode(url, stream);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }

    @RequestMapping(value = "/createLogoQRCode")
    public void createLogoQRCode(HttpServletResponse response, String url) throws Exception {
        ServletOutputStream stream = null;
        try {
            stream = response.getOutputStream();
            String logoPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath()
                    + "templates" + File.separator + "logo.png";
            //使用工具类生成二维码
            QRCodeUtil.encode(url, logoPath, stream, true);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }
}
