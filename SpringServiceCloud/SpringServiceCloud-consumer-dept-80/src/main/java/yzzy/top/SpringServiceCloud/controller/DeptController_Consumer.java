package yzzy.top.SpringServiceCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.yzzy.springcloud.entities.Dept;
import yzzy.top.SpringServiceCloud.Util.HttpUtil;

import java.util.List;

@RestController
public class DeptController_Consumer {
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/consumer/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return restTemplate.postForObject(HttpUtil.REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }
    @GetMapping("/dept/get/{id}")
    public Dept addDept(@PathVariable("id") Long id){
        return restTemplate.getForObject(HttpUtil.REST_URL_PREFIX+"/dept/get"+id,Dept.class);
    }
    @GetMapping(value = "/dept/list")
    public List<Dept> getDept(){
        return restTemplate.getForObject(HttpUtil.REST_URL_PREFIX+"/dept/list", List.class);
    }
    @GetMapping("/discovery")
    public Object discovery() {
        return restTemplate.getForObject(HttpUtil.REST_URL_PREFIX+"/provider/discovery",Object.class);
    }
}
