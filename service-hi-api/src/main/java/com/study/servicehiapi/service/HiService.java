package com.study.servicehiapi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-hi")
public interface HiService {

    @GetMapping("/hi")
    String home(@RequestParam("name") String name);

}
