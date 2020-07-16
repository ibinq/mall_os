package com.bing.mall_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MallAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAppApplication.class, args);
    }

}
