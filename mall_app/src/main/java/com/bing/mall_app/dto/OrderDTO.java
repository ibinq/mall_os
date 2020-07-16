package com.bing.mall_app.dto;

import com.bing.mall_common.entity.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/10 8:00
 */
@Data
public class OrderDTO {
    private Long orderId;

    private Long orderNo;

    private BigDecimal payment;

    private List<OrderItem> orderItemList;
}
