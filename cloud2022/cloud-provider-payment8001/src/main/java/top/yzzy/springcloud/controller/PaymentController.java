package top.yzzy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yzzy.springcloud.entities.CommonResult;
import top.yzzy.springcloud.entities.Payment;
import top.yzzy.springcloud.services.PaymentService;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {
        int count = paymentService.insert(payment);
        log.info("插入结果："+count);
        log.info("插入结果："+count);
        if (count>0){
            return new CommonResult(200,"插入成功",count);
        }else {
            return new CommonResult(404,"插入失败");
        }
    }
    @GetMapping("/payment/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        log.info("查询结果："+payment);
        return new CommonResult(200,"查询成功",payment);
    }
}
