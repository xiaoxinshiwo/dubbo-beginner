package com.xiaoxin.service.impl;

import com.xiaoxin.common.model.Order;
import com.xiaoxin.dao.mapper.TGoodsStorageMapper;
import com.xiaoxin.dao.model.TGoodsStorage;
import com.xiaoxin.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhangyongxin
 * @date 2018/10/26 3:52 PM
 */
@Service
@Transactional(rollbackFor = Exception.class,timeout = 5)
public class OrderServiceImpl implements OrderService {
    @Resource
    private TGoodsStorageMapper mapper;

    @Override
    public void manageStorage(Order order) {
        /**
         * 1. 查询商品库存，判断数量是否足够
         * 2. 扣减库存
         */

        TGoodsStorage record = new TGoodsStorage();
        record.setStoreId(order.getStoreId());
        record.setGoodsId(order.getGoodsId());
        TGoodsStorage storage = mapper.selectOne(record);

        if(null == storage || storage.getAmount()<order.getAmount()){
            throw new UnsupportedOperationException("库存不足");
        }
        storage.setAmount(storage.getAmount()-order.getAmount());
        mapper.updateByPrimaryKey(storage);
    }
}
