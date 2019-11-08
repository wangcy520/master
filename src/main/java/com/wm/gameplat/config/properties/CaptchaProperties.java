package com.wm.gameplat.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Exrickx
 */
@Configuration
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {

    private List<String> image = new ArrayList<>();

    private List<String> sms = new ArrayList<>();

    private List<String> vaptcha = new ArrayList<>();

    private List<String> email = new ArrayList<>();

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public List<String> getSms() {
        return sms;
    }

    public void setSms(List<String> sms) {
        this.sms = sms;
    }

    public List<String> getVaptcha() {
        return vaptcha;
    }

    public void setVaptcha(List<String> vaptcha) {
        this.vaptcha = vaptcha;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }
}
