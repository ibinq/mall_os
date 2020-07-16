package com.bing.mall_app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bing.mall_app.dto.ProductCommentDTO;
import com.bing.mall_app.service.CommentService;
import com.bing.mall_common.entity.Comment;
import com.bing.mall_common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/7 15:13
 */
@RestController
@RequestMapping("app/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public Result add(Comment comment){
        return Result.ok(commentService.save(comment));
    }

    @GetMapping("{uid}")
    public Result commentCount(@PathVariable Long uid){
        Integer need = commentService.selectNeedCommentCount(uid);
        return Result.ok(need);
    }

    @GetMapping("one")
    public Result getOne(@RequestParam("userId") Long userId,
                         @RequestParam("productId") Long productId,
                         @RequestParam("orderId") Long orderId){
        Comment comment = commentService.getOne(new QueryWrapper<Comment>()
                .eq("user_id", userId)
                .eq("product_id", productId).eq("order_id", orderId));
        return Result.ok(comment);
    }

    @GetMapping("list/{uid}")
    public Result commentList(@PathVariable Long uid){
        List<ProductCommentDTO> need = commentService.selectNeedCommentList(uid);
        return Result.ok(need);
    }
    @GetMapping("list1/{uid}")
    public Result commentList1(@PathVariable Long uid){
        List<ProductCommentDTO> need = commentService.selectAddCommentList(uid);
        return Result.ok(need);
    }

}
