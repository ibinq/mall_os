package com.bing.mall_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.mall_back.dto.OrderDTO;
import com.bing.mall_back.mapper.OrderMapper;
import com.bing.mall_back.service.OrderService;
import com.bing.mall_common.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/18 9:30
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<OrderDTO> selectOrderList() {
        return orderMapper.selectOrderList();
    }
}
