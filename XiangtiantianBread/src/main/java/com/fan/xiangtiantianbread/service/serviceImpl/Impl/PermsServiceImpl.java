package com.fan.xiangtiantianbread.service.serviceImpl.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.EmployeeMapper;
import com.fan.xiangtiantianbread.mapper.PermsMapper;
import com.fan.xiangtiantianbread.pojo.Employee;
import com.fan.xiangtiantianbread.pojo.Perms;
import com.fan.xiangtiantianbread.service.serviceImpl.EmployeeService;
import com.fan.xiangtiantianbread.service.serviceImpl.PermsService;
import org.springframework.stereotype.Service;

@Service
public class PermsServiceImpl extends ServiceImpl<PermsMapper, Perms> implements PermsService {
}
