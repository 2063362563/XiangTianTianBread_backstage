package com.fan.xiangtiantianbread.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description consumer
 * @author fan
 * @date 2023-01-25
 */
@Data
public class Consumer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 顾客id
     */
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    /**
     * vip等级，0是没有会员，1是普通会员，2是白银会员，3，是铂金会员，4是钻石会员
     */
    private Integer vip;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 最后一次消费时间
     */
//    private Date lastLogintime;

    /**
     * 生日
     */
    private Date birth;

    /**
     * 电话号码
     */
    private String tel;

    public Consumer() {}
}