package yzzy.top.SpringServiceCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import yzzy.top.SpringServiceCloud.cfgbeans.MyLoadBalancerConfig;
//import yzzy.top.myrule.MySelfRule_WL;

//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import yzzy.top.myrule.MySelfRule_WL;

@SpringBootApplication
@EnableEurekaClient
@LoadBalancerClient(name = "SPRINGSERVICENAME-DEPT",configuration = {MyLoadBalancerConfig.class})
//@ComponentScan("yzzy.top.myrule")
//@ComponentScan("yzzy.top.SpringServiceCloud")
//@RibbonClient(name = "SPRINGSERVICENAME-DEPT",configuration = {MySelfRule_WL.class})
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class);
    }
}
