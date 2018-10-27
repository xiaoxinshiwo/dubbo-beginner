package com.xiaoxin.dao.model;

import javax.persistence.*;

@Table(name = "t_goods_storage")
public class TGoodsStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品id
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 数量
     */
    private Integer amount;

    /**
     * 门店id
     */
    @Column(name = "store_id")
    private Integer storeId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品id
     *
     * @return goods_id - 商品id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品id
     *
     * @param goodsId 商品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取数量
     *
     * @return amount - 数量
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置数量
     *
     * @param amount 数量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 获取门店id
     *
     * @return store_id - 门店id
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * 设置门店id
     *
     * @param storeId 门店id
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }
}