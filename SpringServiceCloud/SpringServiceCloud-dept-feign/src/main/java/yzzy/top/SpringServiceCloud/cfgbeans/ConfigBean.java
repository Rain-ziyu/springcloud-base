package yzzy.top.SpringServiceCloud.cfgbeans;



import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class ConfigBean {
    @Bean
    @LoadBalanced //SpringCloud是基于Netflix Ribbon实现的一套客户端  负载均衡的工作
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
