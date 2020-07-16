package com.bing.mall_back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bing.mall_common.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:00
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
