package com.emall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.emall.product.feign")
@EnableDiscoveryClient
@MapperScan("com.emall.product.dao")
@SpringBootApplication
public class EmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmallProductApplication.class, args);
    }

}
