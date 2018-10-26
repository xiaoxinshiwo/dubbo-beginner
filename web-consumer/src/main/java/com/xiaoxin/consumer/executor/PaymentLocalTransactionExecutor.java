package com.xiaoxin.consumer.executor;

import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.MQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.xiaoxin.consumer.model.UserPayment;
import com.xiaoxin.consumer.service.UserPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 付款事务消息的实现类
 *
 * @author zhangyongxin
 * @date 2018/10/26 2:38 PM
 */
@Component
@Slf4j
public class PaymentLocalTransactionExecutor implements LocalTransactionExecuter {

    @Autowired
    private UserPaymentService userPaymentService;

    @Autowired
    private MQProducer producer;

    /**
     * 1、校验余额是否满足
     * 2、如满足扣减余额
     * 3、发送消息扣减库存,库存充足，扣减成功，库存不足扣减失败
     * 4、不成功，返回失败
     */
    @Override
    public LocalTransactionState executeLocalTransactionBranch(Message message, Object parameter) {
        UserPayment payment = (UserPayment) parameter;

        try {
            userPaymentService.pay(payment);
            return LocalTransactionState.COMMIT_MESSAGE;
        }catch (Exception e) {
            e.printStackTrace();
            return  LocalTransactionState.ROLLBACK_MESSAGE;
        }

    }
}
