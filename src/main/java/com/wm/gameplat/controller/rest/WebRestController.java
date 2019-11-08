package com.wm.gameplat.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 外接产品
 */
@RestController
@RequestMapping(value = "/api/rest")
public class WebRestController {

    @GetMapping("productGame")
    public void queryProductGame() {

    }
}
