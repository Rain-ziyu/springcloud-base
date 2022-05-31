package top.yzzy.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import top.yzzy.springcloud.entities.Dept;
import top.yzzy.springcloud.service.DeptService;

import java.util.List;

@RestController
public class DeptController {

    /**
     * 一旦调用服务方法失败并抛出了异常信息后，会自动调用HystrixCommand注解中的fallback指定的方法
     *
     * @author User
     */
    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)

    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get") //当发生异常会自动进行异常处理
    public Dept get(@PathVariable("id") Long id)
    {
        if(id == 99999){
            throw new RuntimeException();
        }
        return service.get(id);
    }
    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDName("查无此部门");
    }
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        return service.list();
    }

    @RequestMapping(value = "/provider/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("springservicename-dept");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
