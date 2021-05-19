package com.emall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmallOrderApplication.class, args);
    }

}
