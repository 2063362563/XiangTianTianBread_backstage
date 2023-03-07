package com.fan.xiangtiantianbread.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.xiangtiantianbread.pojo.Consumer;

import java.util.List;

public interface ConsumerService extends IService<Consumer> {
    List<Consumer> getAllConsumer(Integer page);

    List<Consumer> getConsumerByNameOrId(String queryContent);

    Integer getConsumerTotal();
}
