package com.fan.xiangtiantianbread.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.xiangtiantianbread.pojo.Good;

import java.util.List;
import java.util.Map;


public interface GoodService extends IService<Good> {

    List<Map<String, Object>> getTodaySaleGood(Integer page);

    Integer getTodaySaleGoodTotal();

    IPage<Good> getGoodIPage(Integer current, LambdaQueryWrapper wrapper);

    Integer getCakeTotal();

    Integer getBreadTotal();
}
