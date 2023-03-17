package com.fan.xiangtiantianbread.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.GoodMapper;
import com.fan.xiangtiantianbread.pojo.Good;
import com.fan.xiangtiantianbread.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Map<String,Object>> getTodaySaleGood(Integer page) {
        List<Map<String,Object>> list = goodMapper.getTodaySaleGood(page);
        return list;
    }

    @Override
    public Integer getTodaySaleGoodTotal() {
        return goodMapper.getTodaySaleGoodTotal();
    }
}
