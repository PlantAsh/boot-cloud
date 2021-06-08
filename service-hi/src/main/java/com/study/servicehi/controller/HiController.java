package com.study.servicehi.controller;

import com.study.servicehi.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @GetMapping("/hi")
    public String home(String name) {
        return hiService.home(name);
    }

}
