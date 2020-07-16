package com.bing.mall_back.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/27 14:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO {
    private Long id;

    private String name;

    private String path;

    private String icon;

    public List<CategoryVO> children;


}
