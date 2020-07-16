package com.bing.mall_back.controller;

import com.bing.mall_back.service.ProductService;
import com.bing.mall_common.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/18 9:32
 */
@Api(tags = "管理员")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @ApiOperation("默认列表")
    @GetMapping
    public Result product(Long id ,String key ,Integer pageNum,Integer pageSize){
        HashMap<String, Object> map = productService.list(id,key, pageNum, pageSize);
        return Result.ok(map);
    }

   /* @ApiOperation("更改状态")
    @GetMapping("/{id}/{status}")
    public Result status(@PathVariable Long id ,@PathVariable  boolean status){
        return Result.ok( adminService.status(id,status));
    }


    @ApiOperation("添加管理员")
    @PostMapping
    public Result add(AdminParm adminParm){
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminParm,admin);
        return Result.status(adminService.add(admin));
    }

    @ApiOperation("删除管理员")
    @DeleteMapping("{id}")
    public Result del(@PathVariable Long id){
        return Result.ok( adminService.deleteById(id));
    }

    @ApiOperation("查询管理员")
    @GetMapping("{id}")
    public Result get(@PathVariable Long id){
        return Result.ok(adminService.selectById(id));
    }

    @ApiOperation("更新管理员")
    @PutMapping
    public Result update(Admin admin){
        return Result.ok(adminService.updateById(admin));
    }*/
}
