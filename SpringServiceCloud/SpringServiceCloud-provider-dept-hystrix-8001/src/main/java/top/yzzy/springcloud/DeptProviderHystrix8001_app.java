package top.yzzy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient //启动后会自动注册到eureka服务端
@EnableHystrix //开启熔断器
public class DeptProviderHystrix8001_app {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix8001_app.class);
    }
}
