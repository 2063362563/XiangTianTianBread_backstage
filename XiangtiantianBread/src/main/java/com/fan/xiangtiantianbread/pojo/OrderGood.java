package com.fan.xiangtiantianbread.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @description order_good
 * @author fan
 * @date 2023-01-25
 */
@Data
public class OrderGood implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 商品id
     */
    private Integer goodId;

    /**
     * 商品数量
     */
    private Integer goodNum;

    public OrderGood() {}
}