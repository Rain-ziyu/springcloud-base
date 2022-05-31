package top.yzzy.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import top.yzzy.springcloud.entities.Dept;

import java.util.List;

/**
 * @author User
 */
@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
