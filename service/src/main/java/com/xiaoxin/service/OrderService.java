package com.xiaoxin.service;

import com.xiaoxin.common.model.Order;

/**
 * @author zhangyongxin
 * @date 2018/10/26 3:51 PM
 */
public interface OrderService {
    /**
     * 库存管理
     * @param order
     */
    void manageStorage(Order order);
}
