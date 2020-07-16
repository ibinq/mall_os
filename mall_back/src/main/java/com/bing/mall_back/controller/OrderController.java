package com.bing.mall_back.controller;

import com.bing.mall_back.dto.OrderDTO;
import com.bing.mall_back.service.OrderService;
import com.bing.mall_common.util.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/18 9:32
 */
@Api(tags = "管理员")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public Result all(){
        //    1.待付款 2.待收货 3.已完成 4.售后
        HashMap<String, List<OrderDTO>> map = new HashMap<>();

        List<OrderDTO> orders  = orderService.selectOrderList();
        List<OrderDTO> toPay = orders.stream().filter(order -> order.getStatus() == 1).collect(Collectors.toList());
        List<OrderDTO> toReceive = orders.stream().filter(order -> order.getStatus() == 2).collect(Collectors.toList());
        List<OrderDTO> completed = orders.stream().filter(order -> order.getStatus() == 3).collect(Collectors.toList());
        List<OrderDTO> saleAfter = orders.stream().filter(order -> order.getStatus() == 4).collect(Collectors.toList());
        map.put("all_order",orders);
        map.put("to_pay",toPay);
        map.put("to_receive",toReceive);
        map.put("completed",completed);
        map.put("sale_after",saleAfter);
        return Result.ok(map);
    }

}
