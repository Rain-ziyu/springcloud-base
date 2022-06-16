package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import com.atguigu.springcloud.alibaba.util.HuToolUtil;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * @author lixiaolong
 * @date 2020-02-26 15:20
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;
    @Autowired
    private HuToolUtil huToolUtil;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     * 注释掉 @GlobalTransactional 的时候，需要注意下方这个方法里面手动模拟了延时，也需要注释掉
     * com.atguigu.springcloud.alibaba.service.impl.AccountServiceImpl#decrease(java.lang.Long, java.math.BigDecimal)
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("----->开始新建订单");
        //1 新建订单
        orderDao.create(order);

        //2 扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //3 扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

        //4 修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");

    }

    @Override
    public Long getId() {
        Executor executor = new ThreadPoolExecutor(2, 2, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolTaskExecutor());
        for (int index = 0;index<20;index++){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Long snowflakeId = huToolUtil.getSnowflakeId();
                log.info("获取Id:" + snowflakeId);
            }
        });}
        return huToolUtil.getSnowflakeId();
    }
}
