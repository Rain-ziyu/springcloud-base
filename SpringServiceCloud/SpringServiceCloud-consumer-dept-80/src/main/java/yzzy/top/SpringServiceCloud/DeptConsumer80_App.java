package yzzy.top.SpringServiceCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import yzzy.top.SpringServiceCloud.cfgbeans.MyLoadBalancerConfig;

//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import yzzy.top.myrule.MySelfRule_WL;

@SpringBootApplication
@EnableEurekaClient
@LoadBalancerClient(name = "SPRINGSERVICENAME-DEPT",configuration = {MyLoadBalancerConfig.class})
//@RibbonClient(name = "SPRINGSERVICENAME-DEPT",configuration = {MySelfRule_WL.class})
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class);
    }
}
