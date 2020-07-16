package com.bing.mall_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.mall_back.mapper.AdminMapper;
import com.bing.mall_back.service.AdminService;
import com.bing.mall_back.vo.AdminVO;
import com.bing.mall_common.entity.Admin;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/18 9:30
 */
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    AdminMapper adminMapper;

    @Override
    public boolean add(Admin admin) {
        //1.判断用户名是否存在
        List<Admin> admins = adminMapper.selectList(new QueryWrapper<Admin>().eq("username", admin.getUsername()));
        if (!admins.isEmpty()){
            return false;
        }
        //2.密码加密处理
        //todo

        admin.setCreateTime(LocalDateTime.now());
        admin.setUpdateTime(LocalDateTime.now());
        admin.setDeleted(0);
        return adminMapper.insert(admin) > 0;
    }

    @Override
    public HashMap<String, Object>  list(String key ,Integer pageNum,Integer pageSize) {

        Page<Admin> page = new Page<>(pageNum, pageSize);//分页类
        QueryWrapper<Admin> entityWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(key)){
            entityWrapper.like("username",key).or()
                    .like("email",key).or()
                    .like("phone",key);
        }
        IPage<Admin> selectPage = adminMapper.selectPage(page, entityWrapper);

        ArrayList<AdminVO> adminVOS = new ArrayList<>();
        selectPage.getRecords().stream().forEach(admin -> {
            AdminVO adminVO = new AdminVO();
            BeanUtils.copyProperties(admin,adminVO);
            adminVOS.add(adminVO);
        });
        HashMap<String, Object> map = new HashMap<>();
        map.put("list",adminVOS);
        map.put("total",page.getTotal());
        return map;
    }

    @Override
    public Boolean status(Long id, boolean status) {
        return adminMapper.status(id,status);
    }
}
