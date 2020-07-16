package com.bing.mall_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.mall_app.mapper.ProductMapper;
import com.bing.mall_app.service.ProductService;
import com.bing.mall_common.entity.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 9:17
 */
@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Resource
    ProductMapper productMapper;
    @Override
    public boolean updateChecked(boolean checked, Long id) {
        return productMapper.updateChecked(checked ,id);
    }
}
