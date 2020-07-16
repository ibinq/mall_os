package com.bing.mall_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.mall_app.dto.OrderDTO;
import com.bing.mall_app.mapper.OrderItemMapper;
import com.bing.mall_app.mapper.OrderMapper;
import com.bing.mall_app.params.OrderParam;
import com.bing.mall_app.service.OrderService;
import com.bing.mall_common.entity.Order;
import com.bing.mall_common.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 9:17
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    OrderMapper orderMapper;
    @Resource
    OrderItemMapper orderItemMapper;

    @Override
    public boolean insertNewOrderAndOrderItem(OrderParam orderParam) {
        Order order = new Order();
        order.setAddressId(orderParam.getAddressId());
        order.setPayment(orderParam.getTotalPrice());
        order.setStatus(1);
        order.setPaymentType(orderParam.getPayway());
        order.setUserId(orderParam.getUid());
        orderMapper.insert(order);
        orderParam.getCarts().stream().forEach(cartDTO -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setUserId(orderParam.getUid());
            orderItem.setProductId(cartDTO.getProductId());
            orderItem.setProductName(cartDTO.getProductName());
            orderItem.setProductImage(cartDTO.getProductHomeImage());
            orderItem.setCurrentUnitPrice(BigDecimal.valueOf(Long.parseLong(cartDTO.getProductPrice())));
            orderItem.setQuantity(cartDTO.getQuantity());
            BigDecimal decimal = new BigDecimal(cartDTO.getQuantity());
            orderItem.setTotalPrice( decimal.multiply(orderItem.getCurrentUnitPrice()));
//            items.add(orderItem);
            orderItemMapper.insert(orderItem);
        });
        return true;
    }

    @Override
    public List<OrderDTO> selectOrderItemList(Long uid, Integer status) {
        return orderMapper.selectOrderItemList(uid,status);
    }


}
