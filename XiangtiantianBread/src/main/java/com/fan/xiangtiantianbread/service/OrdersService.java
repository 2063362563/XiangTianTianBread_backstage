package com.fan.xiangtiantianbread.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.xiangtiantianbread.pojo.Orders;

import java.util.List;

public interface OrdersService extends IService<Orders> {

    List<Integer> getWeekIncome();

}
