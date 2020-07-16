package com.bing.mall_back.parms;

import lombok.Data;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/27 14:20
 */
@Data
public class CategoryParm {

    private Long parentId;

    private String name;

    private String path;

    private String icon;

    private boolean status;

    private Integer level;

    private Integer sort;

}
