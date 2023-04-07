package com.fan.xiangtiantianbread.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fan.xiangtiantianbread.pojo.Consumer;
import com.fan.xiangtiantianbread.service.ConsumerService;
import com.fan.xiangtiantianbread.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/consumer")
@CrossOrigin
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;


    @PostMapping("/saveVip")
    public Result saveVip(@RequestBody Consumer vip) {
        LambdaQueryWrapper<Consumer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Consumer::getTel, vip.getTel());
        if (consumerService.getOne(wrapper) != null) {
            return Result.error("该号码已被注册!");
        }
        Consumer newVip = vip;
        newVip.setAccount(vip.getName());
        newVip.setPassword("123456");
        newVip.setTotalIntegral(new BigDecimal(0));
        newVip.setNowIntegral(new BigDecimal(0));
        newVip.setVip(0);
        return Result.success(consumerService.save(newVip));
    }

    /**
     * 根据id查询会员信息(已通过)
     */
    @GetMapping("/getConsumerById/{consumerId}")
    public Result getConsumerById(@PathVariable Integer consumerId) {
        Consumer consumer = consumerService.getById(consumerId);
        return Result.success(consumer);
    }

    /**
     * 根据name或者id查询会员信息(已通过)
     */
    @GetMapping("/getConsumerByNameOrId")
    public Result getConsumerByName(String queryContent, Integer page) {
        List<Consumer> list = consumerService.getConsumerByNameOrId(queryContent);
        List<Consumer> limitList;
        if (list.size() >= page * 10) {
            limitList = list.subList((page - 1) * 10, page * 10 - 1);
        } else {
            limitList = list.subList((page - 1) * 10, list.size());
        }
        if (list.size() != 0) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("limitList", limitList);
            map.put("total", list.size());
            return Result.success(map);
        }
        return Result.success(null, "查无此人");
    }

    /**
     * 返回总会员数
     */
    @GetMapping("/getConsumerTotal")
    public Result getEmployeeTotal() {
        return Result.success(consumerService.getConsumerTotal());
    }


    /**
     * 分页返回所有会员信息(已通过)
     */
    @GetMapping("/getAllConsumer")
    public Result getAllConsumer(Integer page) {
        List<Consumer> consumerList;
        consumerList = consumerService.getAllConsumer(page);
        return Result.success(consumerList);
    }

    /**
     * 新增会员(已通过)
     */
    @PostMapping("/saveConsumer")
    public Result saveConsumer(@RequestBody Consumer consumer) {
        if (consumer != null) {
            consumer.setAccount(consumer.getName());
            consumer.setPassword("123456");
            consumerService.save(consumer);
            return Result.success(true);
        }
        return Result.error("添加失败");
    }

    /**
     * 根据Id删除会员(已通过)
     */
    @DeleteMapping("/deleteConsumer/{consumerId}")
    public Result deleteConsumer(@PathVariable Integer consumerId) {
        consumerService.removeById(consumerId);
        return Result.success(true);
    }

    /**
     * 修改会员信息(已通过)
     */
    @PutMapping("/updateConsumer")
    public Result updateConsumer(@RequestBody Consumer consumer) {
        if (consumer != null) {
            if (consumerService.updateById(consumer)) {
                return Result.success(true);
            }
            return Result.error("修改失败");
        }
        return Result.error("参数为空");
    }
}
