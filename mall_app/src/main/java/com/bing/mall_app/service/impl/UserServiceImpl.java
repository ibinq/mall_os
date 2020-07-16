package com.bing.mall_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.mall_app.mapper.UserMapper;
import com.bing.mall_app.service.UserService;
import com.bing.mall_common.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 9:17
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
