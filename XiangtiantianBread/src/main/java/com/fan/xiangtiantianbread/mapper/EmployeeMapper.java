package com.fan.xiangtiantianbread.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.xiangtiantianbread.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 分页展示员工数据
     */
    @Select("select * from employee limit ${(page-1)*10},10")
    List<Employee> getAllEmployee(Integer page);

    /**
     * 根据name或者id模糊查询查询员工
     */
    @Select("select * from employee where name like concat('%',#{queryContent},'%') or id like concat('%',#{queryContent},'%')")
    List<Employee> getEmployeeByNameOrId(String queryContent);

    /**
     * 返回总员工数
     */
    @Select("SELECT COUNT(id) FROM employee")
    Integer getEmployeeTotal();


}
