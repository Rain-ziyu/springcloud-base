package top.yzzy.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import top.yzzy.springcloud.entities.Payment;
@Mapper
public interface PaymentDao {
    public int create (Payment payment);
    public Payment getPayment(Long id);
}
