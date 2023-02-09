package com.fan.xiangtiantianbread.service.serviceImpl.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.EmployeeMapper;
import com.fan.xiangtiantianbread.mapper.GoodMapper;
import com.fan.xiangtiantianbread.pojo.Employee;
import com.fan.xiangtiantianbread.pojo.Good;
import com.fan.xiangtiantianbread.service.serviceImpl.EmployeeService;
import com.fan.xiangtiantianbread.service.serviceImpl.GoodService;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements GoodService {
}
