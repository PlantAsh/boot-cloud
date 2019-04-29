package com.study.servicefeign.feign;

import com.study.servicefeign.feign.hystrix.ServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi", fallback = ServiceHiHystrix.class)
public interface ServiceHi {

    @GetMapping(value = "/hi")
    String sayHi(@RequestParam String name);
}
