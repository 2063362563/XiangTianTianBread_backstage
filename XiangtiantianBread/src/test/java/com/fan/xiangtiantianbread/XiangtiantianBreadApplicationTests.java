package com.fan.xiangtiantianbread;

import com.alibaba.fastjson.JSON;
import com.fan.xiangtiantianbread.mapper.GoodMapper;
import com.fan.xiangtiantianbread.pojo.Orders;
import com.fan.xiangtiantianbread.service.EmployeeService;
import com.fan.xiangtiantianbread.service.GoodService;
import com.fan.xiangtiantianbread.service.OrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class XiangtiantianBreadApplicationTests {

    private EmployeeService employeeService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private GoodService goodService;

    //解析
    @Test
    public void test1() {
        System.out.println(goodService.getTodaySaleGood());
    }

}






