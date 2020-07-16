package com.bing.mall_app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bing.mall_common.entity.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:00
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
    void updateDefaulted();
}
