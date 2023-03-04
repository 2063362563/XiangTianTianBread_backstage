package com.fan.xiangtiantianbread.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @description post
 * @author fan
 * @date 2023-01-25
 */
@Data
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 职位id
     */
    private Integer id;

    /**
     * 职位名字
     */
    private String name;

    public Post() {}
}