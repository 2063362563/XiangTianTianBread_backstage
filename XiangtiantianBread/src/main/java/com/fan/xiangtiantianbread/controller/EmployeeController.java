package com.fan.xiangtiantianbread.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fan.xiangtiantianbread.pojo.Employee;
import com.fan.xiangtiantianbread.service.EmployeeService;
import com.fan.xiangtiantianbread.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {



    @Autowired
    private EmployeeService employeeService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Map<String, Object> map){
        String username = (String)map.get("username");
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getAccount,username);
        Employee realEmployee = employeeService.getOne(wrapper);
        if (realEmployee == null){
            return Result.error("该账号尚未注册");
        }
        String password = (String)map.get("password");
        if (!password.equals(realEmployee.getPassword())) {
            return Result.error("用户名或密码错误");
        }
        return Result.success(realEmployee);
    }
    /**
     * 登出
     */
    @PostMapping("/logout/{employeeId}")
    public Result logout(@PathVariable Integer employeeId){
        if(employeeService.setLastLonginDate(employeeId)){
            return Result.success(true);
        }
        return Result.success(false);
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public Result register(){
        return  Result.success(true);
    }

    /**
     * 根据id查询员工信息(已通过)
     */
    @GetMapping("/getEmployeeById/{employeeId}")
    public Result getEmployeeById (@PathVariable Integer employeeId){
        Employee employee = employeeService.getById(employeeId);
        return Result.success(employee);
    }

    /**
     * 根据name或者id查询员工信息(已通过)
     */
    @GetMapping("/getEmployeeByNameOrId")
    public Result getEmployeeByName(String queryContent,Integer page){
        List<Employee> list = employeeService.getEmployeeByNameOrId(queryContent);
        List<Employee> limitList;
        if(list.size() >= page * 10){
            limitList = list.subList((page-1)*10,page*10-1);
        }
        limitList = list.subList((page-1)*10, list.size());
        if (list.size() != 0){
            HashMap<String, Object> map = new HashMap<>();
            map.put("limitList",limitList);
            map.put("total",list.size());
            return Result.success(map);
        }
        return Result.success(null,"查无此人");
    }

    /**
     * 返回总员工数
     */
    @GetMapping("/getEmployeeTotal")
    public Result getEmployeeTotal(){
        return Result.success(employeeService.getEmployeeTotal());
    }

    /**
     * 返回今日商品销量排行
     */
    @GetMapping("/getTodayGoodsRanking")
    public Result GetTodayGoodsRanking(){

        return Result.success(true);
    }

    /**
     * 分页返回所有员工信息(已通过)
     */
    @GetMapping("/getAllEmployee")
    public Result getAllEmployee(Integer page){
        List<Employee> employeeList;
        employeeList = employeeService.getAllEmployee(page);
        return Result.success(employeeList);
    }

    /**
     * 新增员工(已通过)
     */
    @PostMapping("/saveEmployee")
    public Result saveEmployee(@RequestBody Employee employee){
        if(employee != null){
            employee.setAccount(employee.getName());
            employee.setPassword("123456");
            employeeService.save(employee);
            return Result.success(true);
        }
        return Result.error("添加失败");
    }

    /**
     * 根据Id删除员工(已通过)
     */
    @DeleteMapping("/deleteEmployee/{employeeId}")
    public Result deleteEmployee(@PathVariable Integer employeeId){
        employeeService.removeById(employeeId);
        return Result.success(true);
    }

    /**
     * 修改员工信息(已通过)
     */
    @PutMapping("/updateEmployee")
    public Result updateEmployee(@RequestBody Employee employee){
        if(employee != null){
            if(employeeService.updateById(employee)){
                return Result.success(true);
            }
            return Result.error("修改失败");
        }
        return Result.error("参数为空");
    }

}
