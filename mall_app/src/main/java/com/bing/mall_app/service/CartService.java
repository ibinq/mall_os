package com.bing.mall_app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bing.mall_app.dto.CartDTO;
import com.bing.mall_common.entity.Cart;

import java.util.List;


/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:01
 */

public interface CartService extends IService<Cart> {


    List<CartDTO> selectList(Long id);

    boolean updateNum(Long id,Integer quantity);

    boolean allChecked(Long uid, boolean checked);

    Cart selectOne(Long userId, Long productId);

    Integer selectAllProductCount(Long uid);
}
