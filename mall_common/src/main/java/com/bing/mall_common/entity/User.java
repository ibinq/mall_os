package com.bing.mall_common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/3/13 16:30
 */
@Data
@TableName("user")
public class User extends Admin {

    private static final long serialVersionUID = -4055101951194254237L;
    /**
     * 出生年月
     */
    private LocalDate birthday;
}
