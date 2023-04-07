package com.fan.xiangtiantianbread.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.xiangtiantianbread.pojo.OrdersGood;

import java.util.List;
import java.util.Map;

public interface OrdersGoodService extends IService<OrdersGood> {

    public List<Map<String,Object>> getShopHistory(Integer page);

    Integer getShopHistoryTotal();
}
