package com.bing.mall_app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bing.mall_app.dto.ProductCommentDTO;
import com.bing.mall_common.entity.Comment;

import java.util.List;


/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:01
 */

public interface CommentService extends IService<Comment> {


    Integer selectNeedCommentCount(Long uid);

    List<ProductCommentDTO> selectNeedCommentList(Long uid);

    List<ProductCommentDTO> selectAddCommentList(Long uid);
}
