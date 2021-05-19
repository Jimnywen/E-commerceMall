package com.emall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmallThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmallThirdPartyApplication.class, args);
    }

}
