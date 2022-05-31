package yzzy.top.SpringServiceCloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.yzzy.springcloud.entities.Dept;
import top.yzzy.springcloud.service.DeptClientService;
import yzzy.top.SpringServiceCloud.Util.HttpUtil;

import java.util.List;
@Slf4j
@RestController
public class DeptController_Consumer {
    @Autowired
    private DeptClientService service;

    @PostMapping("/dept")
    public boolean addDept(Dept dept){
        return service.addDept(dept);
    }

    @GetMapping("/dept/list")
    public List<Dept> findAll(){
        log.info("Success");
        return service.getDept();
    }

    @GetMapping("/dept/get/{id}")
    public Dept findById(@PathVariable("id")Integer id){
        return service.getDept(Long.valueOf(id));
    }
}
