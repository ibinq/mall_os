package com.bing.mall_app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bing.mall_app.dto.ProductCommentDTO;
import com.bing.mall_common.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:00
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    Integer selectNeedCommentCount(Long uid);

    List<ProductCommentDTO> selectNeedCommentList(Long uid);

    List<ProductCommentDTO> selectAddCommentList(Long uid);
}
