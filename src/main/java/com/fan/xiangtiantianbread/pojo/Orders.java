package com.fan.xiangtiantianbread.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author fan
 * @description order
 * @date 2023-01-25
 */
@Data
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 订单id
     */
    private String id;

    /**
     * 订单生成时间，年月日，时分秒
     */
    private Date date;

    /**
     * 顾客id
     */
    private Integer consumerId;

    /**
     * 总金额
     */
    private BigDecimal total;

    public Orders() {
    }
}