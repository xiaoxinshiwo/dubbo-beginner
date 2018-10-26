package com.xiaoxin.provider.listener;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.xiaoxin.common.model.Order;
import com.xiaoxin.common.util.ProtoStuffUtil;
import com.xiaoxin.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhangyongxin
 * @date 2018/10/26 3:45 PM
 */
@Slf4j
@Component
public class OrderHandleMessageListener implements MessageListenerConcurrently {

    @Autowired
    private OrderService orderService;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        log.info("接收到消息数量为:{}", list.size());
        Order order;
        for (MessageExt msg : list) {
            String topic = msg.getTopic();
            String keys = msg.getKeys();
            order = ProtoStuffUtil.deserialize(msg.getBody(), Order.class);
            log.info("消费者接收到消息:topic: {}, keys:{} , order: {}", topic, keys, order);

            try{
                orderService.manageStorage(order);
            }catch (Exception e){
                e.printStackTrace();
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
