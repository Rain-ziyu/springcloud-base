package com.atguigu.springcloud.service.impl;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import com.atguigu.springcloud.service.IMessageProviderService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.UUID;
import java.util.function.Supplier;


/**
 * @author lixiaolong
 * @EnableBinding(Source.class) 定义消息的推送管道 将Channel和Exchanges绑定在一起
 * @date 2020/12/31 13:35
 */
@Service
//使用函数式进行消息发送

@EnableBinding(Source.class)
public class MessageProviderServiceImpl implements IMessageProviderService {
//    @Resource
//    private KafkaTemplate<String, Message> kafkaTemplate ;
//
//    @Override
//    public String send(String message) {
//        Message<String> messages = MessageBuilder.withPayload(message).build();
//        kafkaTemplate.send(new ProducerRecord<String, Message>("test", messages)).addCallback(result -> {
//            System.out.println("执行成功..." + Thread.currentThread().getName()) ;
//        }, ex -> {
//            System.out.println("执行失败") ;
//            ex.printStackTrace() ;
//        });
//        return message;
//    }

    /**
     * 消息发送管道/信道
     */
//    @Autowired
//    private KafkaSource source;
@Autowired
private MessageChannel output;


//    @Bean
//    public Supplier<String> studentsChannel(){
//        return new Supplier<String>() {
//            @Override
//            public String get() {
//                return send();
//            }
//        };
//    }

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        Message<String> stringMessage = MessageBuilder.withPayload(serial).build();
        output.send(stringMessage);
        System.out.println("*****serial: " + serial);
        return serial;
    }
}
