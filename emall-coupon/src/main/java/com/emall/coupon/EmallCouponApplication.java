package com.emall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmallCouponApplication.class, args);
    }

}
