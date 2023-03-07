package com.fan.xiangtiantianbread.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.xiangtiantianbread.pojo.Good;
import com.fan.xiangtiantianbread.pojo.GoodAndNum;

import java.util.List;
import java.util.Map;


public interface GoodService extends IService<Good> {

    List<GoodAndNum> getTodaySaleGood();

}
