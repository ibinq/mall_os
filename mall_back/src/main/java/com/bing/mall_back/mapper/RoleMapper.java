package com.bing.mall_back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bing.mall_common.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/20 14:08
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> findByUserName(String userName);
}
