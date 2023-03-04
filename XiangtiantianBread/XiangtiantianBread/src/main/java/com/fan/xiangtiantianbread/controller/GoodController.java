package com.fan.xiangtiantianbread.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fan.xiangtiantianbread.pojo.Good;
import com.fan.xiangtiantianbread.service.GoodService;
import com.fan.xiangtiantianbread.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.fan.xiangtiantianbread.utils.Common.upload;

@RestController
@RequestMapping("good")
@CrossOrigin
public class GoodController {

    @Autowired
    private GoodService goodService;

    /**
     * 保存商品
     * @param good
     * @return
     */
    @PostMapping("/saveGood")
    public Result saveGood(@RequestBody Good good){
        return Result.success(goodService.save(good));
    }

    /**
     * 获取今日商品贩卖情况
     * @return
     */
    @GetMapping
    public Result getTodaySaleGood(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "yyyy/MM/dd HH:mm:ss" );
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        LambdaQueryWrapper wrapper = new LambdaQueryWrapper();
        return Result.success(true);
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public Result qwe(MultipartFile file) {
        String url =  upload(file);
        return Result.success("true");
    }

}
