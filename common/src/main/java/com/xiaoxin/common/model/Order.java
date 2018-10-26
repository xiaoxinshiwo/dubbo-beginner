package com.xiaoxin.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhangyongxin
 * @date 2018/10/26 3:16 PM
 */
@Getter
@Setter
@ToString
public class Order implements Serializable {

    private static final long serialVersionUID = -3901057043012525388L;
    /**
     * 购买的商品id
     */
    private Integer goodsId;

    /**
     * 商品数量
     */
    private Integer amount;

    /**
     * 仓库id
     */
    private Integer storeId;
}
