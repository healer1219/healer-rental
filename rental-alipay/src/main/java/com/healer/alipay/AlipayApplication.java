package com.healer.alipay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 李泽炜
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class AlipayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlipayApplication.class,args);
    }

}
