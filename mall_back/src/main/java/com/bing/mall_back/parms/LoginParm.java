package com.bing.mall_back.parms;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/27 14:10
 */
@Data
public class LoginParm {

    @NotNull
    private String username;
    @NotNull
    private String password;

    private Boolean remerberMe;

}
