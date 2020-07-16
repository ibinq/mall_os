package com.bing.mall_common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/27 14:20
 */
@Data
@TableName("category")
public class Category extends BaseEntity {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private Long parentId;

    private String name;

    private String path;

    private String icon;

    private boolean status;

    private Integer level;

    private Integer sort;

}
