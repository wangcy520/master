package com.wm.gameplat.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Component
public class JuHeSms {

    private static final String DEF_CHATSET = "UTF-8";
    private static final int DEF_CONN_TIMEOUT = 30000;
    private static final int DEF_READ_TIMEOUT = 30000;

    //配置您申请的KEY
    private static final String APPKEY ="ae8d61b0f83156295f6521101a2fcdb1";

    //1.屏蔽词检查测
    public static JSONObject getRequest1(){
        String url ="http://v.juhe.cn/sms/black";
        Map<String,Object> params = new HashMap<>();
        params.put("word","");
        params.put("key",APPKEY);
        return getResult(url,params);
    }

    public static JSONObject sendSms(){
        String url ="http://v.juhe.cn/sms/send";
        Map<String,Object> params = new HashMap<>();
        params.put("mobile","18866478840");
        params.put("tpl_id","186265");
        params.put("tpl_value","#code#=635915");
        params.put("key",APPKEY);
        return getResult(url,params);
    }


    private static JSONObject getResult(String url,Map<String,Object> params){
        try {
           String result =net(url, params, "GET");
            return JSONObject.parseObject(result);
        } catch (Exception ignored) {
        }
        return null;
    }

    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    private static String net(String strUrl, Map<String, Object> params, String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuilder sb = new StringBuilder();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlEncode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlEncode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException ignored) {

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    private static String urlEncode(Map<String, Object> data) throws Exception{
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");

        }
        return sb.toString();
    }
}
