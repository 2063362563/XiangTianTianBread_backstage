package com.fan.xiangtiantianbread.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description good
 * @author fan
 * @date 2023-01-25
 */
@Data
public class Good implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品名字
     */
    private String name;

    /**
     * 商品种类(0代表面包，1代表蛋糕)
     */
    private Integer type;

    /**
     * 商品原价
     */
    private BigDecimal price;

    /**
     * 是否是折扣商品
     */
    private Boolean isDiscount;

    /**
     * 是否是新品
     */
    private Boolean isNew;

    /**
     * 商品现价(如果未打折，现价等于原价)
     */
    private BigDecimal nowPrice;

    public Good() {}
}
