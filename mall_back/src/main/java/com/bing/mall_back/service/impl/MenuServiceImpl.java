package com.bing.mall_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.mall_back.mapper.CategoryMapper;
import com.bing.mall_back.service.CategoryService;
import com.bing.mall_back.vo.CategoryVO;
import com.bing.mall_common.entity.Category;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/27 14:23
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    CategoryMapper menuMapper;

    @Override
    public boolean add(Category category) {
        category.setDeleted(0);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        return menuMapper.insert(category) > 0;
    }

    @Override
    public   List<CategoryVO> tree() {
        List<Category> categories = menuMapper.selectList(new QueryWrapper<>());

        CategoryVO parent = new CategoryVO(0L,"商品分类",null,null,new ArrayList<>());

        concreteTree(categories,parent);

        ArrayList<CategoryVO> categoryVOS = new ArrayList<>();
        categoryVOS.add(parent);
        return categoryVOS;
    }

    @Override
    public List<Category> selectById(Long id) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        if (id != null){
            wrapper.eq("parent_id",id);
        }

        return menuMapper.selectList(wrapper);
    }

    @Override
    public List<Category> selectByKey( String key) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(key)){
            wrapper.like("name",key);
        }
        return menuMapper.selectList(wrapper);
    }

    @Override
    public boolean status(Long id, Boolean status) {
        return menuMapper.status(id,status);
    }

    private void concreteTree(List<Category> categories, CategoryVO parentMenuVO){
        List<Category> children = categories.stream().filter(menu -> Objects.equals(parentMenuVO.getId(), menu.getParentId())).collect(Collectors.toList());

        children.forEach(category -> {
            CategoryVO categoryVO = new CategoryVO();
            BeanUtils.copyProperties(category,categoryVO);
            if (parentMenuVO.getChildren() == null) {
                parentMenuVO.setChildren(new LinkedList<>());
            }
            parentMenuVO.getChildren().add(categoryVO);
        });
        categories.removeAll(children);

        if (!CollectionUtils.isEmpty(parentMenuVO.getChildren())) {
            parentMenuVO.getChildren().forEach(childCategory -> concreteTree(categories,childCategory));
        }
    }

}
