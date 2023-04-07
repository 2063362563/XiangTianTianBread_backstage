package com.fan.xiangtiantianbread;

import com.fan.xiangtiantianbread.service.EmployeeService;
import com.fan.xiangtiantianbread.service.GoodService;
import com.fan.xiangtiantianbread.service.OrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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


        String input = "012";
        List<String> result = new ArrayList<>();
        generateCombinations(input, "", result);
        for (String s : result) {
            System.out.println(s);
        }


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




