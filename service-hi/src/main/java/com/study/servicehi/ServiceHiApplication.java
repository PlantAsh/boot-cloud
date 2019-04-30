package com.study.servicehi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ZipkinServer 的功能，收集调用数据
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class ServiceHiApplication {
    private static final Logger log = LoggerFactory.getLogger(ServiceHiApplication.class.getName());

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @GetMapping("/hi")
    public String home(String name) {
        return "hi " + name + " i'm from port:" + port;
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
        log.info("call service-hi");

        return restTemplate.getForObject("http://127.0.0.1:8989/miya", String.class);
    }

    @GetMapping("/info")
    public String info() {
        log.info("call info service-hi");

        return "i'm service-hi";
    }

}
