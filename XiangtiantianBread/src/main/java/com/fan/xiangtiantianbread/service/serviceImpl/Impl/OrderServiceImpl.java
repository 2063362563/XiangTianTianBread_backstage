package com.fan.xiangtiantianbread.service.serviceImpl.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.EmployeeMapper;
import com.fan.xiangtiantianbread.mapper.OrderMapper;
import com.fan.xiangtiantianbread.pojo.Employee;
import com.fan.xiangtiantianbread.pojo.Order;
import com.fan.xiangtiantianbread.service.serviceImpl.EmployeeService;
import com.fan.xiangtiantianbread.service.serviceImpl.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
