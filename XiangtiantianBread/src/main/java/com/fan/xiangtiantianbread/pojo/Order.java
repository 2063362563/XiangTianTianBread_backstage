package com.fan.xiangtiantianbread.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description order
 * @author fan
 * @date 2023-01-25
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 订单id
     */
    private Integer id;

    /**
     * 订单生成时间，年月日，时分秒
     */
    private Date data;

    /**
     * 顾客id
     */
    private Integer consumerId;

    /**
     * 总金额
     */
    private BigDecimal total;

    public Order() {}
}