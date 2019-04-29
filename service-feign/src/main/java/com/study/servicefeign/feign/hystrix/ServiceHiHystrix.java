package com.study.servicefeign.feign.hystrix;

import com.study.servicefeign.feign.ServiceHi;
import org.springframework.stereotype.Component;

@Component
public class ServiceHiHystrix implements ServiceHi {

    @Override
    public String sayHi(String name) {
        return name + ", error!";
    }
}
