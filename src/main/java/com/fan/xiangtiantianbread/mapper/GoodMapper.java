package com.fan.xiangtiantianbread.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.xiangtiantianbread.pojo.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodMapper extends BaseMapper<Good> {

    /**
     * 返回今日商品销售排行
     */
    @Select("SELECT good_name as goods,sum(good_num) as number \n" +
            "from orders_good \n" +
            "LEFT JOIN good on good.id = orders_good.good_id \n" +
            "where order_id IN (SELECT id from orders where date > CURRENT_DATE) \n" +
            "GROUP BY good_id \n" +
            "ORDER BY SUM(good_num) DESC\n" +
            "limit ${(page-1)*8},8")
    List<Map<String, Object>> getTodaySaleGood(Integer page);

    @Select("SELECT COUNT(DISTINCT good_id) as total from orders_good where order_id in (select id from orders where date > CURRENT_DATE)")
    Integer getTodaySaleGoodTotal();

    @Select("SELECT count(id) as total from good WHERE type = '面包'")
    Integer getBreadTotal();

    @Select("SELECT count(id) as total from good WHERE type = '蛋糕'")
    Integer getCakeTotal();
}
