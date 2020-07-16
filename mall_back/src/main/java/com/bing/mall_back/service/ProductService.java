package com.bing.mall_back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bing.mall_common.entity.Product;

import java.util.HashMap;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:01
 */
public interface ProductService extends IService<Product> {

    HashMap<String, Object> list(Long id ,String key, Integer pageNum, Integer pageSize);
}
