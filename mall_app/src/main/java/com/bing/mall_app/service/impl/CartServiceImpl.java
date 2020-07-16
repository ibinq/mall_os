package com.bing.mall_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.mall_app.dto.CartDTO;
import com.bing.mall_app.mapper.CartMapper;
import com.bing.mall_app.service.CartService;
import com.bing.mall_common.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 9:17
 */
@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    @Autowired
    CartMapper cartMapper;
    @Override
    public List<CartDTO> selectList(Long id) {
        return cartMapper.selectList(id);
    }

    @Override
    public boolean updateNum(Long id, Integer quantity) {
        return cartMapper.updateNum(id,quantity);
    }

    @Override
    public boolean allChecked(Long uid, boolean checked) {
        return cartMapper.allChecked(uid,checked);
    }

    @Override
    public Cart selectOne(Long userId, Long productId) {
        return cartMapper.selectOne(userId,productId);
    }

    @Override
    public Integer selectAllProductCount(Long uid) {
        return cartMapper.selectAllProductCount(uid);
    }
}
