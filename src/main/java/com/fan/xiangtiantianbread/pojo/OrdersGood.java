package com.fan.xiangtiantianbread.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fan
 * @description order_good
 * @date 2023-01-25
 */
@Data
public class OrdersGood implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品id
     */
    private Integer goodId;

    /**
     * 商品数量
     */
    private Integer goodNum;

    public OrdersGood() {
    }
}