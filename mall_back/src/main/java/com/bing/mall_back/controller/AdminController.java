package com.bing.mall_back.controller;

import com.bing.mall_back.parms.AdminParm;
import com.bing.mall_back.service.AdminService;
import com.bing.mall_common.entity.Admin;
import com.bing.mall_common.util.MD5Util;
import com.bing.mall_common.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/18 9:32
 */
@Api(tags = "管理员")
@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    AdminService adminService;


    public static void main(String[] args) {

        System.out.println(longestPalindrome("abbc") );
    }


    public static String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {

            stack.push(chars[i]);
        }
        return stack.toString();
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxProduct(TreeNode root) {
        if (root.left != null && root.right != null){

        }


        return 0;
    }
   /* public static int numSteps(String s) {
        BigInteger  a = new BigInteger("0");
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i]=='1') {
                BigInteger pow = (BigInteger) Math.pow(2, chars.length - (i + 1));
                BigInteger integer = new BigInteger(pow);
                a =  a.add(integer);
            }

        }
        int count =0 ;
        if (a.equals("1")){
            return  count ;
        }
        do {
            if (a.divide(new BigInteger("2")).equals(0)){
                a = a.divide(new BigInteger("2")) ;
                count++;
            }else {
                a = a.add(new BigInteger("1")) ;
                count++;
            }
        }while (a.compareTo(new BigInteger("1"))>1);
        return count;
    }*/




    private static List<String> getString(Integer n ){

        List<String> s = new ArrayList<>(n);
        for (int i = 1; i < n + 1 ; i++) {
            if (i%3 == 0 && i%5 == 0){
                s.add("FizzBuzz");
                continue;
            }
            if (i%3 == 0){
                s.add("Fizz");
                continue;
            }
            if (i%5 == 0){
                s.add("Buzz");
                continue;
            }
            s.add(i+"");
        }
        return s;
    }

    @ApiOperation("默认列表")
    @RequiresPermissions("admin:list")
    @GetMapping
    public Result admin(String key ,Integer pageNum,Integer pageSize){
        HashMap<String, Object> map = adminService.list(key, pageNum, pageSize);
        return Result.ok(map);
    }

    @ApiOperation("更改状态")
    @GetMapping("/{id}/{status}")
    public Result status(@PathVariable Long id ,@PathVariable  boolean status){
        return Result.ok( adminService.status(id,status));
    }


    @ApiOperation("添加管理员")
    @RequiresPermissions("admin:add")
    @PostMapping
    public Result add(AdminParm adminParm){
        adminParm.setPassword(MD5Util.encrypt(adminParm.getPassword()));
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminParm,admin);
        return Result.status(adminService.add(admin));
    }

    @ApiOperation("删除管理员")
    @DeleteMapping("{id}")
    public Result del(@PathVariable Long id){
        return Result.ok( adminService.removeById(id));
    }

    @ApiOperation("查询管理员")
    @GetMapping("{id}")
    public Result get(@PathVariable Long id){
        return Result.ok(adminService.getById(id));
    }

    @ApiOperation("更新管理员")
    @PutMapping
    public Result update(Admin admin){
        return Result.ok(adminService.updateById(admin));
    }



}
