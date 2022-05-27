package top.yzzy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient //启动后会自动注册到eureka服务端
public class DeptProvider8001_app {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_app.class);
    }
}
