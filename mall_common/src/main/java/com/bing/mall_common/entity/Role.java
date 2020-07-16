package com.bing.mall_common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/20 14:06
 */
@Data
@TableName("role")
public class Role {
    private Integer id;
    private String name;
    private String memo;

}
