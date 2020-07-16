package com.bing.mall_common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/3/27 18:06
 */
@Data
@TableName("sku_content")
public class SKUContent extends BaseEntity {
    private static final long serialVersionUID = 7657879712762296878L;
    /**
     * 主键
     */
    private Long id;
    /**
     * sku title id
     */
    private Long skuTitleId;
    /**
     * 内容描述
     */
    private String content;
    /**
     * 库存
     */
    private Integer stock;
}