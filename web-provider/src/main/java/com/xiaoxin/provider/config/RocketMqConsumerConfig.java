package com.xiaoxin.provider.config;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.xiaoxin.provider.listener.OrderHandleMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author zhangyongxin
 * @date 2018/10/26 3:39 PM
 */
@Configuration
@Slf4j
public class RocketMqConsumerConfig {

    private DefaultMQPushConsumer consumer;

    @Autowired
    private OrderHandleMessageListener orderHandleMessageListener;

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;


    private static final String GROUP_NAME = "order";

    @PostConstruct
    private void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(GROUP_NAME);

        this.consumer.setNamesrvAddr(namesrvAddr);
        // 启动后从队列头部开始消费
        this.consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        this.consumer.subscribe("GOODS_STORAGE", "*");
        this.consumer.registerMessageListener(orderHandleMessageListener);
        this.consumer.start();
        log.info("consumer started!");
    }
}
