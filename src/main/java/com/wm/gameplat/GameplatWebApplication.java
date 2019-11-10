package com.wm.gameplat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@MapperScan("com.wm.gameplat.core.mapper")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GameplatWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameplatWebApplication.class, args);
    }

}
