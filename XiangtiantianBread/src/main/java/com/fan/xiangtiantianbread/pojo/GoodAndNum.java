package com.fan.xiangtiantianbread.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodAndNum implements Serializable {

    private static final long serialVersionUID = 1L;



    private Integer goodId;



    /**
     * 总金额
     */
    private Integer goodNum;

    public GoodAndNum() {}
}