package yzzy.top.SpringServiceCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import yzzy.top.myrule.MySelfRule_WL;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"top.yzzy.springcloud"})//开启FeignClients
@ComponentScan("top.yzzy.springcloud")//配置扫描公共模块的包即api模块
@ComponentScan("yzzy.top.SpringServiceCloud")
public class DeptConsumer80_Feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign.class);
    }
}
