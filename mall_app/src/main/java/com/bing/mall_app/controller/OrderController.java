package com.bing.mall_app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bing.mall_app.dto.OrderDTO;
import com.bing.mall_app.enums.OrderStatus;
import com.bing.mall_app.params.OrderParam;
import com.bing.mall_app.service.OrderItemService;
import com.bing.mall_app.service.OrderService;
import com.bing.mall_common.entity.Order;
import com.bing.mall_common.entity.OrderItem;
import com.bing.mall_common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/7 15:13
 */
@RestController
@RequestMapping("app/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/list")
    public Result list(Long uid,Integer status){
        //mysql 5.7.5后不能直接group by 先用其他方式代替。todo
//        List<OrderDTO> list = orderService.selectOrderItemList(uid,status);
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",uid);
        if (status!=null && status>0)
            wrapper.eq("status",status);
        List<Order> orders = orderService.list(wrapper);
        List<OrderItem> orderItems = orderItemService.list(new QueryWrapper<OrderItem>().eq("user_id", uid));
        List<OrderDTO> list = new ArrayList<>();
        orders.stream().forEach(order -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId(order.getId());
            orderDTO.setOrderNo(order.getOrderNo());
            orderDTO.setPayment(order.getPayment());
            orderDTO.setOrderItemList(new ArrayList<OrderItem>());

            orderItems.stream().forEach(orderItem -> {
                if (order.getId().equals(orderItem.getOrderId()))
                    orderDTO.getOrderItemList().add(orderItem);
            });
            list.add(orderDTO);

        });
        return Result.ok(list);
    }

    @GetMapping("/count")
    public Result count(Long uid,Integer status){
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        if (status!=null){
            wrapper.eq("status",status);
        }
        wrapper.eq("user_id",uid);
        List<Order> list = orderService.list(wrapper);
        HashMap<String, Long> map = new HashMap<>();
        long count = list.stream().filter(order -> order.getStatus() == 1).count();
        long count2 = list.stream().filter(order -> order.getStatus() == 2).count();
        long count3 = list.stream().filter(order -> order.getStatus() == 3).count();
        long count4 = list.stream().filter(order -> order.getStatus() == 4).count();
        long count5 = list.stream().filter(order -> order.getStatus() == 5).count();

        map.put("badge1",count);
        map.put("badge2",count2);
        map.put("badge3",count3);
        map.put("badge4",count4);
        map.put("badge5",count5);
        return Result.ok(map);
    }

    @PostMapping
    public Result add(@RequestBody OrderParam orderParam){

        Order order = new Order();
        order.setAddressId(orderParam.getAddressId());
        order.setPayment(orderParam.getTotalPrice().divide(new BigDecimal(100)));
        order.setStatus(OrderStatus.TO_BE_PAID.getValue());
        order.setPaymentType(orderParam.getPayway());
        order.setUserId(orderParam.getUid());
        orderService.save(order);

        orderParam.getCarts().stream().forEach(cartDTO -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setUserId(orderParam.getUid());
            orderItem.setProductId(cartDTO.getProductId());
            orderItem.setProductName(cartDTO.getProductName());
            orderItem.setProductImage(cartDTO.getProductHomeImage());
            Double l = Double.parseDouble(cartDTO.getProductPrice());
            BigDecimal value = BigDecimal.valueOf(l);
            orderItem.setCurrentUnitPrice(value);
            orderItem.setQuantity(cartDTO.getQuantity());
            BigDecimal decimal = new BigDecimal(cartDTO.getQuantity());
            orderItem.setTotalPrice( decimal.multiply(orderItem.getCurrentUnitPrice()));
//            items.add(orderItem);
            orderItemService.save(orderItem);
        });
        return Result.ok();
    }


}
