package com.fan.xiangtiantianbread.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.OrdersMapper;
import com.fan.xiangtiantianbread.pojo.Orders;
import com.fan.xiangtiantianbread.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Integer> getWeekIncome() {
        return ordersMapper.getWeekIncome();
    }
}
