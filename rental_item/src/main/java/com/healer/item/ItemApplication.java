package com.healer.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李泽炜
 * @package com.healer.item
 * @time 2021/3/2 17:55
 * @Description TODO
 */
@Configuration
@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.healer.entity.item")
public class ItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemApplication.class, args);
    }
}
