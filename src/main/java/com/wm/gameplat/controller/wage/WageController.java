package com.wm.gameplat.controller.wage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日工资
 *
 * @author
 */
@RestController
@RequestMapping(value = "/api/wage")
public class WageController {

    @PostMapping("/config/save")
    public void save() {
    }
}
