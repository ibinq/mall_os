package com.bing.mall_app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bing.mall_app.dto.CartDTO;
import com.bing.mall_common.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:00
 */
@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    List<CartDTO> selectList(Long id);

    boolean updateNum(@Param("id") Long id,@Param("quantity") Integer quantity);

    boolean allChecked(@Param("uid")Long uid, @Param("checked")boolean checked);

    Cart selectOne(@Param("userId")Long userId, @Param("productId")Long productId);

    Integer selectAllProductCount(Long uid);
}
