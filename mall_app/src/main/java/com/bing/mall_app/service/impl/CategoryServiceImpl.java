package com.bing.mall_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.mall_app.mapper.CategoryMapper;
import com.bing.mall_app.service.CategoryService;
import com.bing.mall_common.entity.Category;
import org.springframework.stereotype.Service;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 9:17
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
