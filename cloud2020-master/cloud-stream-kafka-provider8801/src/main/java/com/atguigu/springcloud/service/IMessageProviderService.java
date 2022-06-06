package com.atguigu.springcloud.service;

import org.apache.kafka.common.protocol.types.Field;

/**
 * @author lixiaolong
 */
public interface IMessageProviderService {
    /**
     * 定义消息的推送管道
     *
     * @return
     */
    String send();
}
