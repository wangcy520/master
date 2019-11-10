package com.wm.gameplat;


import com.alibaba.fastjson.JSON;
import com.wm.gameplat.config.core.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCenterTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void getTest() {

        System.out.println(JSON.toJSONString(userInfoService.findByUsername("karl")));
    }


}
