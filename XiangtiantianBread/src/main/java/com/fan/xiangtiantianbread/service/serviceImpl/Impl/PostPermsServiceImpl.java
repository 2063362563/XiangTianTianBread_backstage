package com.fan.xiangtiantianbread.service.serviceImpl.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.EmployeeMapper;
import com.fan.xiangtiantianbread.mapper.PostPermsMapper;
import com.fan.xiangtiantianbread.pojo.Employee;
import com.fan.xiangtiantianbread.pojo.Post;
import com.fan.xiangtiantianbread.pojo.PostPerms;
import com.fan.xiangtiantianbread.service.serviceImpl.EmployeeService;
import com.fan.xiangtiantianbread.service.serviceImpl.PostPermsService;
import org.springframework.stereotype.Service;

@Service
public class PostPermsServiceImpl extends ServiceImpl<PostPermsMapper, PostPerms> implements PostPermsService {
}
