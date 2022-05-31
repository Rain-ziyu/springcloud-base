package top.yzzy.springcloud.service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import top.yzzy.springcloud.entities.Dept;

import java.util.List;
@Component // 不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable cause) {

        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept getDept(Long id) {
                 	return new Dept().setDeptNo(id).setDName("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDbSource("no this database in MySQL");
            }

            @Override
            public List<Dept> getDept() {
                return null;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
