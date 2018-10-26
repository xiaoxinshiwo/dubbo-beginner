package com.xiaoxin.consumer.service.impl;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.MQProducer;
import com.alibaba.rocketmq.client.producer.TransactionSendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.xiaoxin.common.util.ProtoStuffUtil;
import com.xiaoxin.consumer.executor.PaymentLocalTransactionExecutor;
import com.xiaoxin.consumer.model.UserPayment;
import com.xiaoxin.consumer.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 支付总入口
 * @author zhangyongxin
 * @date 2018/10/26 3:04 PM
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PaymentLocalTransactionExecutor paymentLocalTransactionExecutor;

    @Autowired
    private MQProducer mqProducer;

    @Override
    public void pay(UserPayment payment) {
        Message message = new Message();
        message.setTopic("GOODS_STORAGE");
        message.setBody(ProtoStuffUtil.serialize(payment.getOrder()));
        TransactionSendResult sendResult = null;
        try {
            sendResult = mqProducer.sendMessageInTransaction(message,paymentLocalTransactionExecutor,payment);
        } catch (MQClientException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("支付失败");
        }
        if (sendResult.getLocalTransactionState() == LocalTransactionState.ROLLBACK_MESSAGE) {
            throw new UnsupportedOperationException("支付失败");
        }
    }
}
