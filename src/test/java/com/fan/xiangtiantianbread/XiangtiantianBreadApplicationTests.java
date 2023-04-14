package com.fan.xiangtiantianbread;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fan.xiangtiantianbread.pojo.Good;
import com.fan.xiangtiantianbread.service.EmployeeService;
import com.fan.xiangtiantianbread.service.GoodService;
import com.fan.xiangtiantianbread.service.OrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
class XiangtiantianBreadApplicationTests {

    private EmployeeService employeeService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private GoodService goodService;

    private static void generateCombinations(String input, String current, List<String> result) {
        if (!current.isEmpty()) {
            result.add(current);
        }
        for (int i = 0; i < input.length(); i++) {
            generateCombinations(input.substring(i + 1), current + input.charAt(i), result);
        }
    }

    //解析
    @Test
    public void test1() {


        LambdaQueryWrapper<Good> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Good::getIsDiscount, 1);


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




