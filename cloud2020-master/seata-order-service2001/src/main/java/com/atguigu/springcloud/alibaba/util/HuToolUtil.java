package com.atguigu.springcloud.alibaba.util;

import cn.hutool.core.lang.Snowflake;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.NetworkInterface;
@Slf4j
@Component
public class HuToolUtil {
    private Long workId=0L;
    private Long dataCenterId = 1L;
    private Snowflake snowflake =  IdUtil.getSnowflake(workId, dataCenterId);
    @PostConstruct
    public void  init(){
        try {
            workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("获取本地ip作为workId正常");
        } catch (Exception e) {
            log.info("获取不到本地地址");
            workId = Long.valueOf(NetUtil.getLocalhostStr().hashCode());
            throw new RuntimeException(e);
        }
    }
    public synchronized Long getSnowflakeId(){
       return snowflake.nextId();
    }
    public synchronized Long getAnotherSnowflakeId(Long workId,Long dataCenterId ){
      return   IdUtil.getSnowflake(workId, dataCenterId).nextId();
    }


}
