package com.study.servicemiya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class ServiceMiyaApplication {
    private static final Logger log = LoggerFactory.getLogger(ServiceMiyaApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ServiceMiyaApplication.class, args);
    }

    //测试zipkin
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/callHome")
    public String callHome() {
        log.info("call service-miya");

        return restTemplate.getForObject("http://127.0.0.1:8763/info", String.class);
    }

    @GetMapping("/miya")
    public String info() {
        log.info("call info service-miya");

        return "i'm service-miya";
    }

}
