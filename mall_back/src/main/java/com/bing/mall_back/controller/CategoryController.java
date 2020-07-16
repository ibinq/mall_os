package com.bing.mall_back.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bing.mall_back.parms.CategoryParm;
import com.bing.mall_back.service.CategoryService;
import com.bing.mall_common.entity.Category;
import com.bing.mall_common.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/27 14:24
 */
@Api("分类")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService menuService;

    @ApiOperation("默认列表")
    @GetMapping
    public Result list(String id, String key ,Integer pageSize,Integer pageNum){
        Page<Category> page = new Page<>(pageNum, pageSize);//分页类
        QueryWrapper<Category> entityWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(key)){
            entityWrapper.like("name",key);
        }
        if (id !=null){
            entityWrapper.like("parent_id",id);
        }
//        Page<Category> page1 =  menuService.selectPage(page,entityWrapper);
        Page<Category> categoryPage = menuService.page(page, entityWrapper);

        HashMap<String, Object> map = new HashMap<>();
        map.put("list",categoryPage.getRecords());
        map.put("total",categoryPage.getTotal());
        return Result.ok(map);
    }

    @ApiOperation("树形列表")
    @GetMapping("tree")
    public Result tree(){
        return Result.ok(menuService.tree());
    }

    @ApiOperation("添加菜单")
    @PostMapping
    public Result add(CategoryParm categoryParm){
       // Assert.isNull(menuParm,"menuParm 不能为空！");
        Category category = new Category();
        BeanUtils.copyProperties(categoryParm,category);
        return Result.status(menuService.add(category));
    }

    @ApiOperation("删除菜单")
    @DeleteMapping("{id}")
    public Result del(@PathVariable Long id){
        return Result.ok(menuService.removeById(id));
    }

    @ApiOperation("详细信息")
    @GetMapping("{id}")
    public Result get(@PathVariable Long id){
        return Result.ok(menuService.selectById(id));
    }

    @ApiOperation("更新状态")
    @GetMapping("/{id}/{status}")
    public Result get(@PathVariable Long id ,@PathVariable Boolean status){
        return Result.ok(menuService.status(id,status));
    }

    @ApiOperation("更新分类")
    @PutMapping()
    public Result put(Category category){
        return Result.ok(menuService.updateById(category));
    }



//    @ApiOperation("更新菜单")
//    @PutMapping
//    public Result update(@RequestBody Category category){
//        category.setUpdateTime(LocalDateTime.now());
//        return Result.ok(menuService.updateById(category));
//    }
}
