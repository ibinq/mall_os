package com.bing.mall_common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/3/27 18:04
 */
@Data
@TableName("sku_title")
public class SKUTitle extends BaseEntity {
    private static final long serialVersionUID = -4457189549682449708L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 产品 id
     */
    private Long productId;
    /**
     * sku 标题
     */
    private String title;
}
