package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lixiaolong
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConfigClient3355Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient3355Application.class, args);
        System.out.println("启动成功");

    }
}
