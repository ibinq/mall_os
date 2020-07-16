package com.bing.mall_common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/3/13 16:30
 */
@Data
@TableName("admin")
@ToString
@EqualsAndHashCode(callSuper = true)
public class Admin extends BaseEntity {

    private static final long serialVersionUID = -8729843597528752557L;
    /**
     * 主键
     */
    @TableId(type=IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 状态
     */
    private Boolean status;


}
