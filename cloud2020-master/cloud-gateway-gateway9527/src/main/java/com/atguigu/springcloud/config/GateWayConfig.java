package com.atguigu.springcloud.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixiaolong
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//         /**可以代理路径下的转发  改版本已经移除了一级路由
        routes.route("path_route_atguigu", r -> r.path("/guoji/**").uri("http://news.baidu.com/guonei"))
                .build();
        return routes.build();
    }
}

