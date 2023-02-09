package com.yasuo.auth;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: xk
 * @Date: 2023/2/6 14:23
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableKnife4j
public class YasuoAuthSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(YasuoAuthSpringApplication.class, args);
    }
}
