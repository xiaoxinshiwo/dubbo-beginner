package com.xiaoxin.consumer.service.impl;

import com.xiaoxin.consumer.mapper.UserPaymentMapper;
import com.xiaoxin.consumer.model.UserPayment;
import com.xiaoxin.consumer.service.UserPaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhangyongxin
 * @date 2018/10/26 2:31 PM
 */
@Service
@Transactional(rollbackFor = Exception.class,timeout = 5)
public class UserPaymentServiceImpl implements UserPaymentService {
    @Resource
    private UserPaymentMapper mapper;

    @Override
    public void pay(UserPayment payment) {

        UserPayment record = new UserPayment();
        record.setUserId(payment.getUserId());
        UserPayment paymentInDB =  mapper.selectOne(record);

        if(paymentInDB == null || paymentInDB.getRemainder().compareTo(payment.getPayAmount())<0){
            //一般会自定义业务异常，这里仅使用UnsupportedOperationException做样例
            throw new UnsupportedOperationException("余额不足");
        }
        paymentInDB.setRemainder(paymentInDB.getRemainder()-payment.getPayAmount());
        mapper.updateByPrimaryKey(paymentInDB);


    }
}
