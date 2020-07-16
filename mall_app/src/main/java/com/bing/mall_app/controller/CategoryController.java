package com.bing.mall_app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bing.mall_app.service.CategoryService;
import com.bing.mall_app.vo.CategoryVO;
import com.bing.mall_common.entity.Category;
import com.bing.mall_common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 9:14
 */
@RestController
@RequestMapping("app/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public Result categorys(){
        List<Category> categories = categoryService.list(
                new QueryWrapper<Category>()
                        .eq("deleted", 0)
                        .eq("parent_id",0));
        return Result.ok(categories);
    }

    @GetMapping("{id}")
    public Result childCategories(@PathVariable Long id){
        List<Category> categories = categoryService.list(new QueryWrapper<Category>());
        Set<Category> collect = categories.stream().filter(category -> category.getParentId().equals(id)).collect(Collectors.toSet());
        ArrayList<CategoryVO> list = new ArrayList<>();
        collect.stream().forEach(category -> {
            CategoryVO vo = new CategoryVO();
            vo.setId(category.getId());
            vo.setName(category.getName());
            vo.setIcon(category.getIcon());
            vo.setPath(category.getPath());
            list.add(vo);
        });

        categories.removeAll(collect);

        list.stream().forEach(categoryVO -> {
            categories.stream().forEach(category -> {
                if (category.getParentId().equals(categoryVO.getId())){
                    if (categoryVO.getChildren() == null) {
                        categoryVO.setChildren(new LinkedList<>());
                    }
                    CategoryVO categoryVO1 = new CategoryVO();
                    categoryVO1.setPath(category.getPath());
                    categoryVO1.setIcon(category.getIcon());
                    categoryVO1.setName(category.getName());
                    categoryVO1.setId(category.getId());
                    categoryVO.getChildren().add(categoryVO1);
                }
            });
        });

        return Result.ok(list);
    }





}
