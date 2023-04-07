package com.fan.xiangtiantianbread.controller;

import com.fan.xiangtiantianbread.service.OrdersGoodService;
import com.fan.xiangtiantianbread.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderGood")
@CrossOrigin
public class OrdersGoodController {

    @Autowired
    private OrdersGoodService ordersGoodService;

    @GetMapping("/getShopHistory/{page}")
    public Result getShopHistory(@PathVariable Integer page){
        List<Map<String, Object>> list = ordersGoodService.getShopHistory(page);
        return Result.success(list);
    }

    /**
     * 返回总查询数
     */
    @GetMapping("/getShopHistoryTotal")
    public Result getShopHistoryTotal(){
        return Result.success(ordersGoodService.getShopHistoryTotal());
    }
}
