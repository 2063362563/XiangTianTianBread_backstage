package com.fan.xiangtiantianbread.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.xiangtiantianbread.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    /**
     * 使用了WITH语句和UNION ALL来创建一个临时表date_range，然后使用LEFT JOIN将其与orders表连接，并使用COALESCE函数处理空值。
     * @return
     */
    @Select("WITH date_range AS (\n" +
            "    SELECT DATE_SUB(CURRENT_DATE, INTERVAL 6 DAY) AS date\n" +
            "    UNION ALL\n" +
            "    SELECT DATE_SUB(CURRENT_DATE, INTERVAL 5 DAY)\n" +
            "    UNION ALL\n" +
            "    SELECT DATE_SUB(CURRENT_DATE, INTERVAL 4 DAY)\n" +
            "    UNION ALL\n" +
            "    SELECT DATE_SUB(CURRENT_DATE, INTERVAL 3 DAY)\n" +
            "    UNION ALL\n" +
            "    SELECT DATE_SUB(CURRENT_DATE, INTERVAL 2 DAY)\n" +
            "    UNION ALL\n" +
            "    SELECT DATE_SUB(CURRENT_DATE, INTERVAL 1 DAY)\n" +
            "    UNION ALL\n" +
            "    SELECT CURRENT_DATE\n" +
            ")\n" +
            "SELECT COALESCE(SUM(orders.total), 0) AS total FROM date_range LEFT JOIN orders ON date_range.date = DATE(orders.date) GROUP BY date_range.date;")
    List<Integer> getWeekIncome();

}
