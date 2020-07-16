package com.bing.mall_app.dto;

import com.bing.mall_common.entity.Product;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/8 14:24
 */
@Data
public class CartDTO {
    private Long id;

    private Long productId;

    private String productHomeImage;

    private String productName;

    private String productDesc;

    private String productPrice;

    private Integer quantity;

    private Boolean checked;
}
