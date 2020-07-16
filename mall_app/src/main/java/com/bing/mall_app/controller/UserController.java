package com.bing.mall_app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bing.mall_app.mapper.UserMapper;
import com.bing.mall_app.service.UserService;
import com.bing.mall_common.entity.User;
import com.bing.mall_common.util.MD5Util;
import com.bing.mall_common.util.Result;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/7 15:13
 */
@RestController
@RequestMapping("app/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(String username,String password) throws UnsupportedEncodingException {

        User user = userService.getOne(new QueryWrapper<User>()
                .eq("username", username)
                .eq("password", MD5Util.encrypt(password)));
        HashMap<String, Object> map = new HashMap<>();
        map.put("username",user.getUsername());
        map.put("id",user.getId());
        String s = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 60*60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "zhoubing")
                .compact();
        HashMap<String, Object> hashMap = new HashMap<>();
        user.setPassword("");
        hashMap.put("token",s);
//        Object json = JSONObject.toJSON(user);
        hashMap.put("user",user);
        return Result.ok(hashMap);
    }

    public static void main(String[] args) throws IOException {
        //前三步都相同
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        //这里不再调用SqlSession 的api，而是获得了接口对象，调用接口中的方法。
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


    }

}
