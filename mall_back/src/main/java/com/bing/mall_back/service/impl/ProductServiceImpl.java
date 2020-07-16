package com.bing.mall_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.mall_back.mapper.CategoryMapper;
import com.bing.mall_back.mapper.ProductMapper;
import com.bing.mall_back.service.ProductService;
import com.bing.mall_common.entity.Category;
import com.bing.mall_common.entity.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/18 9:30
 */
@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    ProductMapper productMapper;
    @Resource
    CategoryMapper categoryMapper;

    @Override
    public HashMap<String, Object> list(Long id ,String key, Integer pageNum, Integer pageSize) {
        Page<Product> page = new Page<>(pageNum, pageSize);//分页类
        QueryWrapper<Product> entityWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(key)){
            entityWrapper.like("title",key) ;
        }
        if (id != null){
            ArrayList<Category> list = new ArrayList<>();
            getAllChildCategory(id,list);
            Set<Long> collect = list.stream().map(product -> product.getId()).collect(Collectors.toSet());
            collect.add(id);
            entityWrapper.in("category_id",collect);
        }
        List<Product> products = (List<Product>) productMapper.selectPage(page, entityWrapper);
        HashMap<String, Object> map = new HashMap<>();
        map.put("products",products);
        map.put("total",page.getTotal());
        return map;
    }


    private List<Category> getAllChildCategory(Long id,ArrayList<Category> list){
        List<Category> categories = categoryMapper.selectList(new QueryWrapper<Category>().eq("parent_id", id));
        list.addAll(categories);
        if (categories.size()>0){
            Set<Long> longs = categories.stream().map(product -> product.getId()).collect(Collectors.toSet());
            for (Long i:longs  ) {
                getAllChildCategory(i,list);
            }
        }
        return list;
    }
}
