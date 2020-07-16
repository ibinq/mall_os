package com.bing.mall_back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bing.mall_common.entity.Admin;

import java.util.HashMap;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:01
 */
public interface AdminService  extends IService<Admin> {
    boolean add(Admin admin );

    HashMap<String, Object> list(String key , Integer pageNum, Integer pageSize);

    Boolean status(Long id, boolean status);
}
