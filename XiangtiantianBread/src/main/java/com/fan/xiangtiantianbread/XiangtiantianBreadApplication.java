package com.fan.xiangtiantianbread;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.fan.xiangtiantianbread.mapper")
@Slf4j
public class XiangtiantianBreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiangtiantianBreadApplication.class, args);
        log.info("项目启动成功");
    }

}
