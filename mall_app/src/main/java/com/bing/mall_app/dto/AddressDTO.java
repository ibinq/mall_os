package com.bing.mall_app.dto;

import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 17:52
 */
@Data
public class AddressDTO {

    private Long id;
    private  String name;
    private  String tel;
    private String address;
    private Boolean isDefault;
}
