package com.study.servicefeign.controller;

import com.study.servicehiapi.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private HiService hiService;

    @GetMapping(value = "/hi")
    public String sayHi(String name) {
        return hiService.home(name);
    }
}
