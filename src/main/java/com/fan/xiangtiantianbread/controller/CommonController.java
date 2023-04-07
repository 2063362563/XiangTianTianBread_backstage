package com.fan.xiangtiantianbread.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fan.xiangtiantianbread.pojo.Consumer;
import com.fan.xiangtiantianbread.pojo.Orders;
import com.fan.xiangtiantianbread.pojo.OrdersGood;
import com.fan.xiangtiantianbread.pojo.PayRequest;
import com.fan.xiangtiantianbread.service.ConsumerService;
import com.fan.xiangtiantianbread.service.OrdersGoodService;
import com.fan.xiangtiantianbread.service.OrdersService;
import com.fan.xiangtiantianbread.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/common")
@CrossOrigin
public class CommonController {

    @Autowired
    private OrdersGoodService ordersGoodService;

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private OrdersService ordersService;

    @Transactional
    public BigDecimal basePay(List<Map<String, Object>> cart, Integer consumerId) {
        if (cart == null) {
            return null;
        }
        //新建订单表
        Orders order = new Orders();
        BigDecimal total = BigDecimal.valueOf(0);
        String uuid = UUID.randomUUID().toString();
        order.setDate(new Date());
        order.setConsumerId(consumerId);
        order.setId(uuid);
        for (Map<String, Object> item : cart) {
            //取数据
            Integer goodId = (Integer) item.get("goodId");
            Integer price = (Integer) item.get("price");
            Integer num = (Integer) item.get("num");
            //新建关系表
            OrdersGood ordersGood = new OrdersGood();
            ordersGood.setOrderId(uuid);
            ordersGood.setGoodId(goodId);
            ordersGood.setGoodNum(num);
            ordersGoodService.save(ordersGood);
            //累加总金额
            total = total.add(BigDecimal.valueOf(price).multiply(BigDecimal.valueOf(num)));
        }
        order.setTotal(total);
        ordersService.save(order);
        return total;
    }

    @Transactional
    @PostMapping("/pay")
    public Result pay(@RequestBody List<Map<String, Object>> cart) {
        return Result.success(basePay(cart, null));
    }

    @Transactional
    @PostMapping("/payWithVip")
    public Result payWithVip(@RequestBody PayRequest payRequest) {
        //判断会员信息
        String tel = payRequest.getTel();
        LambdaQueryWrapper<Consumer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Consumer::getTel, tel);
        Consumer consumer = consumerService.getOne(wrapper);
        if (consumer == null) {
            return Result.error("该号码尚未注册会员,请先注册!");
        }
        //基础支付
        BigDecimal total = basePay(payRequest.getCart(), consumer.getId());
        //给与会员优惠
        Integer level = consumer.getVip();
        switch (level) {
            case 3:
                total = total.multiply(BigDecimal.valueOf(0.85));
                break;
            case 2:
                total = total.multiply(BigDecimal.valueOf(0.9));
                break;
            case 1:
                total = total.multiply(BigDecimal.valueOf(0.95));
                break;
        }
        //更改会员信息
        consumer.setNowIntegral(consumer.getNowIntegral().add(total));
        BigDecimal totalIntegral = consumer.getTotalIntegral().add(total);
        consumer.setTotalIntegral(totalIntegral);
        //判断总积分,来修改会员等级
        if (totalIntegral.compareTo(BigDecimal.valueOf(1000)) > 0) {
            consumer.setVip(3);
        } else if (totalIntegral.compareTo(BigDecimal.valueOf(500)) > 0) {
            consumer.setVip(2);
        } else if (totalIntegral.compareTo(BigDecimal.valueOf(200)) > 0) {
            consumer.setVip(1);
        }
        consumerService.updateById(consumer);
        return Result.success(total);
    }

}
