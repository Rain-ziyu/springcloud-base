package top.yzzy.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.yzzy.springcloud.entities.Dept;

import java.util.List;

/**
 * @author User
 */
//@FeignClient(value = "SPRINGSERVICENAME-DEPT")
@FeignClient(value = "SPRINGSERVICENAME-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {


    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept);

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    public List<Dept> getDept();

    @GetMapping("/provider/discovery")
    public Object discovery() ;
}