package com.wm.gameplat.controller.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/system")
public class SystemController {


    /**
     * 取系统参数
     */
    @GetMapping("/params")
    public void queryParams() {

    }
}
