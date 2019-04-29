package com.study.servicefeign.controller;

import com.study.servicefeign.feign.ServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    private final ServiceHi serviceHi;

    @Autowired
    public FeignController(ServiceHi serviceHi) {
        this.serviceHi = serviceHi;
    }

    @GetMapping(value = "/hi")
    public String sayHi(String name) {
        return serviceHi.sayHi(name);
    }
}
