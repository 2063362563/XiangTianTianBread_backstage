package com.fan.xiangtiantianbread.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.xiangtiantianbread.pojo.Good;
import com.fan.xiangtiantianbread.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodMapper extends BaseMapper<Good> {

    /**
     * 返回今日商品销售排行
     */
    @Select("SELECT * FROM `orders` WHERE `data` = date_format(now(),'%y-%m-%d');")
    List<Orders> getTodaySaleGood();
}
