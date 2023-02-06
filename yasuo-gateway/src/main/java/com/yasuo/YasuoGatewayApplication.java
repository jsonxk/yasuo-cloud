package com.yasuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description:
 * @Author: xk
 * @Date: 2023/2/2 14:07
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class YasuoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(YasuoGatewayApplication.class, args);
    }
}
