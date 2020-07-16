package com.bing.mall_app.vo;

import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 17:52
 */
@Data
public class AddressVO {

    private Long id;

    private Long userId;

    private String name;

    private String tel;

    private String country;

    private String province;

    private String city;

    private String county;

    private String areaCode;

    private String postalCode;

    private String addressDetail;

    private Boolean isDefault;
}
