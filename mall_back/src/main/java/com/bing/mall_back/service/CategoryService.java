package com.bing.mall_back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bing.mall_back.vo.CategoryVO;
import com.bing.mall_common.entity.Category;

import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:01
 */

public interface CategoryService extends IService<Category> {

    boolean add(Category category);

    List<CategoryVO> tree();

    List<Category> selectById(Long id);

    List<Category> selectByKey(String key);

    boolean status(Long id, Boolean status);
}
