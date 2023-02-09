package com.fan.xiangtiantianbread.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @description perms
 * @author fan
 * @date 2023-01-25
 */
@Data
public class Perms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 权限id
     */
    private Integer id;

    /**
     * 权限内容
     */
    private String content;

    public Perms() {}
}