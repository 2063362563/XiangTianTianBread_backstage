package com.fan.xiangtiantianbread.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public List<Map<String, Object>> getTodaySaleGood(Integer page) {
        List<Map<String, Object>> list = goodMapper.getTodaySaleGood(page);
        return list;
    }

    @Override
    public IPage<Good> getGoodIPage(Integer current, LambdaQueryWrapper wrapper) {
        Page<Good> page = new Page<>(current, 5);
        IPage<Good> goodIPage = goodMapper.selectPage(page, wrapper);
        return goodIPage;
    }

    /**
     * typeName填种类(面包,蛋糕),返回该种类在数据库中的种数
     */
    @Override
    public Integer getBreadTotal() {
        return goodMapper.getBreadTotal();
    }

    @Override
    public Integer getCakeTotal() {
        return goodMapper.getCakeTotal();
    }

    @Override
    public Integer getTodaySaleGoodTotal() {
        return goodMapper.getTodaySaleGoodTotal();
    }
}
