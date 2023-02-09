package com.fan.xiangtiantianbread.service.serviceImpl.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.ConsumerMapper;
import com.fan.xiangtiantianbread.mapper.EmployeeMapper;
import com.fan.xiangtiantianbread.pojo.Consumer;
import com.fan.xiangtiantianbread.pojo.Employee;
import com.fan.xiangtiantianbread.service.serviceImpl.ConsumerService;
import com.fan.xiangtiantianbread.service.serviceImpl.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {
}
