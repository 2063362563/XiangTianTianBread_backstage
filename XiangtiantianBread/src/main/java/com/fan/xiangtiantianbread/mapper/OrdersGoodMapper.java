package com.fan.xiangtiantianbread.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.xiangtiantianbread.pojo.OrdersGood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersGoodMapper extends BaseMapper<OrdersGood> {

    @Select("SELECT DATE_FORMAT(orders.date, '%Y年%m月%d日 %H:%i:%s') as time,order_id as orderId,consumer.`name` as username,good.good_name as goods,orders_good.good_num as number,good.price,orders_good.good_num*good.price as total\n" +
            "FROM orders\n" +
            "JOIN orders_good ON orders.id = orders_good.order_id\n" +
            "JOIN good ON good.id = orders_good.good_id\n" +
            "JOIN consumer ON consumer.id = orders.consumer_id\n" +
            "ORDER BY orders.date DESC\n" +
            "LIMIT ${(page-1)*5},5")
    List<Map<String,Object>> getsShopHistory(Integer page);

    @Select("select COUNT(good_id) as total from orders_good where order_id in (select id from orders ORDER BY date DESC)")
    Integer getShopHistoryTotal();

}
