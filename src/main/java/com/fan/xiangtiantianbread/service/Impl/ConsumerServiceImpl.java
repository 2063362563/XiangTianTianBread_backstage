package com.fan.xiangtiantianbread.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.ConsumerMapper;
import com.fan.xiangtiantianbread.pojo.Consumer;
import com.fan.xiangtiantianbread.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;


    @Override
    public List<Consumer> getAllConsumer(Integer page) {
        return consumerMapper.getAllConsumer(page);
    }

    @Override
    public List<Consumer> getConsumerByNameOrId(String queryContent) {
        return consumerMapper.getConsumerByNameOrId(queryContent);
    }

    @Override
    public Integer getConsumerTotal() {
        return consumerMapper.getConsumerTotal();
    }
}
