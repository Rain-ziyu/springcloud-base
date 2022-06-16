package top.yzzy.snowflake.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import top.yzzy.snowflake.service.OrderService;
import top.yzzy.snowflake.util.HuToolUtil;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * @author lixiaolong
 * @date 2020-02-26 15:20
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private HuToolUtil huToolUtil;


    @Override
    public Long getId() {
        ExecutorService executor = new ThreadPoolExecutor(2, 2, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20), new ThreadPoolTaskExecutor());
        for (int index = 0;index<20;index++){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Long snowflakeId = huToolUtil.getSnowflakeId();
                log.info("获取Id:" + snowflakeId);
            }
        });}
        //关闭
        executor.shutdown();
        return huToolUtil.getSnowflakeId();
    }
}
