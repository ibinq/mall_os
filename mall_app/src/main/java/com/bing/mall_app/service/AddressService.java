package com.bing.mall_app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bing.mall_common.entity.Address;


/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/15 16:01
 */

public interface AddressService extends IService<Address> {


    void updateDefaulted();
}
