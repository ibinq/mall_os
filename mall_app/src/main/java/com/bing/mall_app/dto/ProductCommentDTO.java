package com.bing.mall_app.dto;

import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/10 14:25
 */
@Data
public class ProductCommentDTO {

    private Long uid;

    private Long productId;

    private Long orderId;

    private String productName;

    private String productDesc;

    private String productImage;

}
