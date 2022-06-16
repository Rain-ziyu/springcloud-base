package top.yzzy.snowflake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yzzy.snowflake.service.OrderService;

@RestController
@RequestMapping("/ID")
public class IdController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/id")
    public Long getId(){
    Long id = orderService.getId();
    return id;
    }
}
