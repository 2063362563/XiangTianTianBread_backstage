package com.fan.xiangtiantianbread.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.xiangtiantianbread.pojo.Good;

import java.util.List;
import java.util.Map;


public interface GoodService extends IService<Good> {

    List<Map<String,Object>> getTodaySaleGood(Integer page);

    Integer getTodaySaleGoodTotal();

}
