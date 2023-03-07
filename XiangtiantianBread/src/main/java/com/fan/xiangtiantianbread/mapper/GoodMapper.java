package com.fan.xiangtiantianbread.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.xiangtiantianbread.pojo.Good;
import com.fan.xiangtiantianbread.pojo.GoodAndNum;
import com.fan.xiangtiantianbread.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodMapper extends BaseMapper<Good> {

    /**
     * 返回今日商品销售排行
     */
    @Select("SELECT good_id,sum(good_num) from orders_good where order_id IN (SELECT id from orders where data = CURRENT_DATE) GROUP BY good_id ORDER BY SUM(good_num) DESC")
    List<GoodAndNum> getTodaySaleGood();
}
