package com.bing.mall_app.controller;

import com.bing.mall_app.dto.CartDTO;
import com.bing.mall_app.service.CartService;
import com.bing.mall_common.entity.Cart;
import com.bing.mall_common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/7 15:13
 */
@RestController
@RequestMapping("app/carts")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    public Result add(Cart cart) {
        Cart c = cartService.selectOne(cart.getUserId(),cart.getProductId());
        if (c!=null){
            c.setQuantity(c.getQuantity() + 1);
            return Result.ok( cartService.updateById(c));
        }else {
            return Result.ok( cartService.save(cart));
        }

    }

    @GetMapping("{id}")
    public Result list(@PathVariable Long id) {
        List<CartDTO> carts =cartService.selectList(id);
        return Result.ok(carts);
    }

    @GetMapping("/num")
    public Result num(@RequestParam Long id,@RequestParam Integer quantity) {
        boolean b = cartService.updateNum(id ,quantity);
        return Result.ok(b);
    }
    @GetMapping("/allChecked")
    public Result allChecked(@RequestParam Long uid ,@RequestParam boolean checked) {
        boolean b = cartService.allChecked(uid,checked);
        return Result.ok(b);
    }

    @GetMapping("/count")
    public Result count(Long id) {
        Integer b = cartService.selectAllProductCount(id);
        return Result.ok(b);
    }

    @GetMapping("/checked/{id}")
    public Result checked(@PathVariable Long id) {
        List<CartDTO> carts =cartService.selectList(id);
        List<CartDTO> list = carts.stream().filter(cartDTO -> cartDTO.getChecked()).collect(Collectors.toList());
        return Result.ok(list);
    }

}
