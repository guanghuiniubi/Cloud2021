package com.guanghui;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@Slf4j
@MapperScan(value = "com.guanghui.mapper")
@ServletComponentScan(value = "com.guanghui")
@SpringBootApplication
@EnableEurekaClient
public class PaymentApplication {
    public static void main(String[] args){
        SpringApplication.run(PaymentApplication.class,args);
    }
}
