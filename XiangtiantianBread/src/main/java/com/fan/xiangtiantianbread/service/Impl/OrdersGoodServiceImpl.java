package com.fan.xiangtiantianbread.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.OrdersGoodMapper;
import com.fan.xiangtiantianbread.pojo.OrdersGood;
import com.fan.xiangtiantianbread.service.OrdersGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrdersGoodServiceImpl extends ServiceImpl<OrdersGoodMapper, OrdersGood> implements OrdersGoodService {

    @Autowired
    private OrdersGoodMapper ordersGoodMapper;

    @Override
    public List<Map<String, Object>> getShopHistory(Integer page) {
        List<Map<String, Object>> list = ordersGoodMapper.getsShopHistory(page);
        return list;
    }

    @Override
    public Integer getShopHistoryTotal() {
        return ordersGoodMapper.getShopHistoryTotal();
    }
}
