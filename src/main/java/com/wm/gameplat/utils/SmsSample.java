package com.wm.gameplat.utils;

import com.wm.gameplat.config.properties.SmsbaoProperties;
import com.wm.gameplat.constant.CommonConstant;
import com.wm.gameplat.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

@Component
public class SmsSample {

    @Autowired
    private SmsbaoProperties smsbaoProperties;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public Result sendMessage(String mobile, HttpServletRequest request) {

        String testUsername = smsbaoProperties.getUsername();

        String testPassword = smsbaoProperties.getPassword();

        String smsCode = CreateVerifyCode.getSmsCode(4);

        String ipAddr = IpInfoUtil.getIpAddr(request);

        if (stringRedisTemplate.opsForValue().get(CommonConstant.PRE_SMS + ipAddr) != null) {
            return ResultUtil.error("请求太过频繁，请一分钟后再试！");
        }
        String testContent = String.format("【短信宝】您的验证码是%s,30秒内有效。", smsCode);//短信模板
        String httpUrl = "http://api.smsbao.com/sms";
        String httpArg = "u=" + testUsername + "&" +
                "p=" + md5(testPassword) + "&" +
                "m=" + mobile + "&" +
                "c=" + encodeUrlString(testContent);
        String strResult = request(httpUrl, httpArg);
        if ("0".equals(strResult)) {
            stringRedisTemplate.opsForValue().set(CommonConstant.PRE_SMS + mobile, smsCode, 5L, TimeUnit.MINUTES);
            stringRedisTemplate.opsForValue().set(ipAddr, "", 1L, TimeUnit.MINUTES);
            return  ResultUtil.success();
        }
        return   ResultUtil.error();
    }

    private static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuilder sbf = new StringBuilder();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String strRead = reader.readLine();
            if (strRead != null) {
                sbf.append(strRead);
                while ((strRead = reader.readLine()) != null) {
                    sbf.append("\n");
                    sbf.append(strRead);
                }
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String md5(String plainText) {
        StringBuffer buf = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            buf = new StringBuffer();
            for (byte aB : b) {
                i = aB;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    private static String encodeUrlString(String str) {
        String strRet;
        if (str == null)
            return null;
        try {
            strRet = java.net.URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strRet;
    }
}
