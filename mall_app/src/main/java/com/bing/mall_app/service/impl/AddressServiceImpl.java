package com.bing.mall_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bing.mall_app.mapper.AddressMapper;
import com.bing.mall_app.service.AddressService;
import com.bing.mall_common.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 9:17
 */
@Service("addressService")
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    @Autowired
    AddressMapper addressMapper;
    @Override
    public void updateDefaulted() {
        addressMapper.updateDefaulted();
    }
}
