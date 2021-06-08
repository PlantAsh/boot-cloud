package com.study.servicehi.service.impl;

import com.study.servicehi.service.HiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HiServiceImpl implements HiService {

    @Value("${server.port}")
    private String port;

    @Override
    public String home(String name) {
        return "hi " + name + " i'm from port:" + port;
    }

}
