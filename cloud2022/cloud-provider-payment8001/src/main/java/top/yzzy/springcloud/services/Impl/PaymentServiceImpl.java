package top.yzzy.springcloud.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yzzy.springcloud.dao.PaymentDao;
import top.yzzy.springcloud.entities.Payment;
import top.yzzy.springcloud.services.PaymentService;


/**
 * @author User
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Payment queryById(Long id) {
        return this.paymentDao.getPayment(id);
    }

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(Payment payment) {
        int i = this.paymentDao.create(payment);
        return i;
    }


}
