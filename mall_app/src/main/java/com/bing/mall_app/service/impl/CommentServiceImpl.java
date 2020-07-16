package com.bing.mall_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.mall_app.dto.ProductCommentDTO;
import com.bing.mall_app.mapper.CommentMapper;
import com.bing.mall_app.service.CommentService;
import com.bing.mall_common.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 9:17
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public Integer selectNeedCommentCount(Long uid) {
        return commentMapper.selectNeedCommentCount(uid);
    }

    @Override
    public List<ProductCommentDTO> selectNeedCommentList(Long uid) {
        return commentMapper.selectNeedCommentList(uid);
    }

    @Override
    public List<ProductCommentDTO> selectAddCommentList(Long uid) {
        return commentMapper.selectAddCommentList(uid);
    }
}
