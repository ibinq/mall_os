package com.bing.mall_app.params;

import com.bing.mall_app.dto.CartDTO;
import com.bing.mall_common.entity.Cart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/9 10:07
 */
@Data
public class OrderParam {
    private Long uid;
    private Long addressId;
    private Integer payway;
    private BigDecimal totalPrice;
    private List<CartDTO> carts;
}
