package com.fan.xiangtiantianbread.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.GoodMapper;
import com.fan.xiangtiantianbread.pojo.Good;
import com.fan.xiangtiantianbread.pojo.GoodAndNum;
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
    public List<GoodAndNum> getTodaySaleGood() {
        List<GoodAndNum> list = goodMapper.getTodaySaleGood();

        return list;
    }
}
