package com.guanghui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class Eureka8002SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(Eureka8002SpringbootApplication.class,args);
    }
}
