package com.fan.xiangtiantianbread.service.serviceImpl.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.EmployeeMapper;
import com.fan.xiangtiantianbread.mapper.OrderGoodMapper;
import com.fan.xiangtiantianbread.pojo.Employee;
import com.fan.xiangtiantianbread.pojo.OrderGood;
import com.fan.xiangtiantianbread.service.serviceImpl.EmployeeService;
import com.fan.xiangtiantianbread.service.serviceImpl.OrderGoodService;
import org.springframework.stereotype.Service;

@Service
public class OrderGoodServiceImpl extends ServiceImpl<OrderGoodMapper, OrderGood> implements OrderGoodService {
}
