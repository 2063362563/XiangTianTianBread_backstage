package com.fan.xiangtiantianbread.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.xiangtiantianbread.pojo.Employee;

import java.util.List;

public interface EmployeeService extends IService<Employee>{

    List<Employee> getAllEmployee(Integer page);

    List<Employee> getEmployeeByNameOrId(String queryContent);

    Integer getEmployeeTotal();
}
