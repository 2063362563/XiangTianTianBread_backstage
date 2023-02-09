package com.fan.xiangtiantianbread.service.serviceImpl.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.xiangtiantianbread.mapper.PostMapper;
import com.fan.xiangtiantianbread.pojo.Post;
import com.fan.xiangtiantianbread.service.serviceImpl.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
}
