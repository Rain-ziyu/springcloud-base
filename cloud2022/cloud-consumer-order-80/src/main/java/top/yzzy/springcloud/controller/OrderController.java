package top.yzzy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.yzzy.springcloud.Util.HttpUtil;
import top.yzzy.springcloud.entities.CommonResult;
import top.yzzy.springcloud.entities.Payment;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        //注意该方法的payment会放到body中
        return restTemplate.postForObject(HttpUtil.REST_URL_PREFIX + "/payment/create", payment, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        return restTemplate.getForObject(HttpUtil.REST_URL_PREFIX + "/payment/"+id, CommonResult.class);
    }
}
