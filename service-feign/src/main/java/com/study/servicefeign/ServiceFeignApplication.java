package com.study.servicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单
 * Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
 * Hystrix组件，实现了断路器模式 Feign自带断路器
 */
@EnableDiscoveryClient
@EnableFeignClients("com.study.*")
@SpringBootApplication
public class ServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }

}
