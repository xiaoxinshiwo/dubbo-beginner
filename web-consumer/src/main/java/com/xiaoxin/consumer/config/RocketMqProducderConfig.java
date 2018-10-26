package com.xiaoxin.consumer.config;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.MQProducer;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangyongxin
 * @date 2018/10/26 1:56 PM
 */
@Configuration
@Slf4j
public class RocketMqProducderConfig {


    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;


    private static final String GROUP_NAME = "order";


    @Bean
    public MQProducer mqProducer() throws MQClientException {
        TransactionMQProducer mqProducer = new TransactionMQProducer(GROUP_NAME);
        mqProducer.setNamesrvAddr(namesrvAddr);
        mqProducer.setTransactionCheckListener(msg -> {
            // doNothing
            return LocalTransactionState.COMMIT_MESSAGE;
        });
        Runtime.getRuntime().addShutdownHook(new Thread(() -> mqProducer.shutdown()));
        mqProducer.start();
        log.info("producer started!");
        return mqProducer;    }
}
