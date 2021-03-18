package com.healer.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 李泽炜
 * @package PACKAGE_NAME
 * @time 2021/3/3 16:38
 * @Description TODO
 */
@EnableEurekaClient
@SpringBootApplication
@EntityScan(value = {"com.healer.entity.order","com.healer.entity.item"})
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
