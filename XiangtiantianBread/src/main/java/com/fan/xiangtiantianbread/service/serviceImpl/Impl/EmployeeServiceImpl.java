package com.fan.xiangtiantianbread.service.serviceImpl.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.EmployeeMapper;
import com.fan.xiangtiantianbread.pojo.Employee;
import com.fan.xiangtiantianbread.service.serviceImpl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee(Integer page) {
        return employeeMapper.getAllEmployee(page);
    }

    @Override
    public List<Employee> getEmployeeByNameOrId(String queryContent) {
        return employeeMapper.getEmployeeByNameOrId(queryContent);
    }

    @Override
    public Integer getEmployeeTotal() {
        return employeeMapper.getEmployeeTotal();
    }
}
