package com.bing.mall_app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bing.mall_app.dto.AddressDTO;
import com.bing.mall_app.service.AddressService;
import com.bing.mall_app.vo.AddressVO;
import com.bing.mall_common.entity.Address;
import com.bing.mall_common.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/6 17:36
 */
@RestController
@RequestMapping("app/addresses")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping
    public Result add(AddressVO address){
        Address address1 = new Address();
        BeanUtils.copyProperties(address,address1);
        address1.setDefaulted(address.getIsDefault());
        //修改数据库中当前的默认地址为false
        if (address.getIsDefault()){
            addressService.updateDefaulted();
        }
        return Result.ok(addressService.save(address1));
    }

    @GetMapping("list/{id}")
    public Result list(@PathVariable Long id){
        List<Address> addresses = addressService.list(new QueryWrapper<Address>().eq("user_id",id));
        ArrayList<AddressDTO> list = new ArrayList<>();
        addresses.stream().forEach(address -> {
            AddressDTO dto = new AddressDTO();
            dto.setId(address.getId());
            dto.setName(address.getName());
            dto.setTel(address.getTel());
            dto.setAddress(address.getProvince()+address.getCity()+address.getCounty()+address.getAddressDetail());
            dto.setIsDefault(address.getDefaulted());
            list.add(dto);
        });
        return Result.ok(list);
    }

    @GetMapping("{id}")
    public Result getOne(@PathVariable Long id){
        Address address = addressService.getOne(new QueryWrapper<Address>().eq("id", id));
        AddressVO vo = new AddressVO();
        BeanUtils.copyProperties(address,vo);
        vo.setIsDefault(address.getDefaulted());
        return Result.ok(vo);
    }

    @PutMapping
    public Result update(AddressVO address){
        Address address1 = new Address();
        BeanUtils.copyProperties(address,address1);
        address1.setDefaulted(address.getIsDefault());
        if (address.getIsDefault()){
            addressService.updateDefaulted();
        }
        return Result.ok(addressService.updateById(address1));
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Long id){
        return Result.ok(addressService.removeById(id));
    }

}
