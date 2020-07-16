package com.bing.mall_back.parms;

import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/18 10:57
 */
@Data
public class AdminParm   {
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
     * 状态0启用，1冻结
     */
    private boolean status;
}
