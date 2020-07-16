package com.bing.mall_app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bing.mall_app.service.ProductService;
import com.bing.mall_common.entity.Product;
import com.bing.mall_common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 9:14
 */
@RestController
@RequestMapping("app/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public Result list(){

        List<Product> products = productService.list(new QueryWrapper<>());
        return Result.ok(products);
    }

    @GetMapping("{categoryId}")
    public Result list(@PathVariable  Long categoryId){
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        if (categoryId != null){
            wrapper.eq("category_id",categoryId);
        }
        List<Product> products = productService.list(wrapper);
        return Result.ok(products);
    }

    @GetMapping("one/{id}")
    public Result getOne(@PathVariable  Long id){
        return Result.ok(productService.getById(id));
    }

    @GetMapping("/checked")
    public Result updateChecked(@RequestParam Long id,@RequestParam boolean checked){
        boolean b = productService.updateChecked(!checked , id);
        return Result.ok();
    }






}
