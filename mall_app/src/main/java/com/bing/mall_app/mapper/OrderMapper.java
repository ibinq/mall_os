package com.bing.mall_app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bing.mall_app.dto.OrderDTO;
import com.bing.mall_common.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:00
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    List<OrderDTO> selectOrderItemList(@Param("uid") Long uid, @Param("status") Integer status);
}
