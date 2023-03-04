package com.fan.xiangtiantianbread.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;


/**
 * @description employee
 * @author fan
 * @date 2023-01-24
 */
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 员工id
     */
    private Integer id;

    /**
     * 员工名字
     */
    private String name;

    /**
     * 职位
     */
    private Integer post;

    /**
     * 最后登录时间
     */
    private Date lastLogintime;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别(0是男，1是女,2是保密)
     */
    private Integer sex;

    /**
     * 月薪
     */
    private BigDecimal salary;

    /**
     * 入职日期
     */
    private Date entryDate;

    /**
     * 生日
     */
    private Date birth;

    public Employee() {}
}