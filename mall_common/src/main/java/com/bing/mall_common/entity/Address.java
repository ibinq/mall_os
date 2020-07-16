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
 * @date 2020/7/6 17:14
 */
@Data
@TableName("address")
@ToString
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseEntity {
    private static final long serialVersionUID = -2504309620869228691L;
    /**
     * 主键
     */
    @TableId(type= IdType.AUTO)
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

    private Boolean defaulted;

















}
