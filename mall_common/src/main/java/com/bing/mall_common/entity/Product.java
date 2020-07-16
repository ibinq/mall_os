package com.bing.mall_common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品
 */
@Data
@TableName("product")
public class Product extends BaseEntity {

    private static final long serialVersionUID = 4960017291273018583L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 产品名
     */
    private String title;

    /**
     * 产品副标题
     */
    private String subTitle;

    /**
     * 主图
     */
    private String mainImage;

    /**
     * 详细图
     */
    private String subImage;

    /**
     * 详细描述
     */
    private String detail;
    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;
    /**
     * 状态
     */
    private Boolean status;

    private String homeImage;

}