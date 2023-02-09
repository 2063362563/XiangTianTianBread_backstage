package com.fan.xiangtiantianbread.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @description post_perms
 * @author fan
 * @date 2023-01-25
 */
@Data
public class PostPerms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 职位id
     */
    private Integer postId;

    /**
     * 权限id
     */
    private Integer permsId;

    public PostPerms() {}
}