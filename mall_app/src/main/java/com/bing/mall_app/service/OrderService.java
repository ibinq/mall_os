package com.bing.mall_app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bing.mall_app.dto.OrderDTO;
import com.bing.mall_app.params.OrderParam;
import com.bing.mall_common.entity.Order;

import java.util.List;


/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:01
 */
public interface OrderService extends IService<Order> {
    boolean insertNewOrderAndOrderItem(OrderParam orderParam);

    List<OrderDTO> selectOrderItemList(Long uid, Integer status);
}
