package com.bing.mall_common.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/3/16 10:40
 */
@Data
@TableName("permission")
public class Permission extends BaseEntity {

    private static final long serialVersionUID = -8974937619430390499L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 菜单id
     */
    private Long menuId;
    /**
     * 名称
     */
    private String name;
    /**
     * 值
     */
    private String value;
    /**
     * 状态
     */
    private Boolean status;

}
