package com.xiaoxin.consumer.model;

import com.xiaoxin.common.model.Order;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user_payment")
@Getter
@Setter
@ToString
public class UserPayment implements Serializable {

    private static final long serialVersionUID = 4796222382060728002L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 余额
     */
    private Double remainder;

    /**
     * 支付金额
     */
    @Transient
    private Double payAmount;

    /**
     * 订单详情
     */
    @Transient
    private Order order;

}