package com.bing.mall_back.controller;

import com.bing.mall_common.util.MD5Util;
import com.bing.mall_common.util.Result;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/27 14:09
 */
@Api("登录")
@RestController
@RequestMapping
public class LoginController {

    @PostMapping("/login")
    public Result login(String username,String password,boolean remeberMe){
        // 密码MD5加密
        // password = MD5Utils.encrypt(username, password);
//        password = MD5Util.encrypt(password);
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        // 获取Subject对象
//        Subject subject = SecurityUtils.getSubject();
//        try {
//
//            subject.login(token);
//            JwtBuilder builder= Jwts.builder()
//                    .setId(password)
//                    .setSubject(username)
//                    .setIssuedAt(new Date())//设置签发时间
//                    .signWith(SignatureAlgorithm.HS256,"zhoubing");
//            System.out.println(builder.compact());

            return Result.ok();

//        } catch ( Exception e) {
//            return Result.fail(e.getMessage());
//        }

    }
    @GetMapping("/logout")
    public Result logout(){
        return Result.ok();
    }


}
