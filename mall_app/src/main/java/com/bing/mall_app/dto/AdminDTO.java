package com.bing.mall_app.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.bing.mall_common.converter.OutputConverter;
import com.bing.mall_common.entity.Admin;
import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/18 10:59
 */
@Data
public class AdminDTO implements OutputConverter<AdminDTO, Admin> {
    /**
     * 主键
     */
    @TableId(type= IdType.AUTO)
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
