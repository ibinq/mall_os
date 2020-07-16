package com.bing.mall_common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/10 14:00
 */
@Data
@TableName("comment")
public class Comment extends BaseEntity{

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private Long parentId;

    private Long userId;

    private Long productId;

    private Long orderId;

    private String content;

    private String imageList;

    private Integer status;//是否匿名

    private Double productStar;//商品评价

    private Double deliveryStar;//快递评价

    private Double speedStar;//送货速度

    private Double serviceStar;//服务评价
}
