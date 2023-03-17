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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    }

    @Test
    public void test2() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        String datalist = "";
        for (int i = 6; i >= 0; i--) {
            LocalDate date = today.minusDays(i);
            String formattedDate = date.format(formatter);
            datalist = datalist.concat(formattedDate + ',');
        }
        datalist = datalist.substring(0, datalist.length() - 1);
        System.out.println(datalist);
    }

}

//datalist = datalist+','+formattedDate;




