package com.bing.mall_common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/3/13 16:09
 */
@Data
@TableName("size")
public class Size extends BaseEntity {
    private static final long serialVersionUID = 159148584817305152L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long uid;
    /**
     * 名称
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 身高
     */
    private Integer height;
    /**
     * 体重
     */
    private Integer weight;
    /**
     * 肩宽
     */
    private Integer shoulder;
    /**
     * 胸围
     */
    private Integer bust;
    /**
     * 腰围
     */
    private Integer waistline;
    /**
     * 臀围
     */
    private Integer hipline;
    /**
     * 脚长
     */
    private Integer footLength;
    /**
     * 脚宽
     */
    private Integer footLine;

    /**
     * 是否默认 1 是 ； 0 否
     */
    private Integer select;



}
