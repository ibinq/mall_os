/*
package com.bing.mall_common.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bing.mall_common.repository.BaseRepository;
import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Sort;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

*/
/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/18 9:06
 *//*

public class AbstractCrudService<DOMAIN,ID> implements CrudService<DOMAIN,ID> {

    //private final String domainName;

    private final BaseRepository<DOMAIN, ID> repository;

    protected AbstractCrudService(BaseRepository<DOMAIN, ID> repository) {
        this.repository = repository;

//        @SuppressWarnings("unchecked")
//        Class<DOMAIN> domainClass = (Class<DOMAIN>) fetchType(0);
//        domainName = domainClass.getSimpleName();
    }

//    private Type fetchType(int index) {
//        Assert.isTrue(index >= 0 && index <= 1, "type index must be between 0 to 1");
//        return ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[index];
//    }


    @Override
    public List<DOMAIN> listAll() {
        return repository.selectList(new QueryWrapper<>());
    }

    @Override
    public List<DOMAIN> listAll(String column, boolean isAsc) {
        QueryWrapper<DOMAIN> wrapper = new QueryWrapper<>();
        wrapper.orderBy(Boolean.parseBoolean(column),isAsc);
        return repository.selectList(wrapper);
    }

    @Override
    public Page<DOMAIN> listAll(Integer pageNum , Integer pageSize) {
        List<DOMAIN> domains = (List<DOMAIN>) repository.selectPage((IPage<DOMAIN>) new RowBounds((pageNum - 1) * pageSize, pageSize),
                new QueryWrapper<DOMAIN>());
        return null;
    }

    @Override
    public List<DOMAIN> listAllByIds(Collection<ID> ids) {
        return null;
    }

    @Override
    public List<DOMAIN> listAllByIds(Collection<ID> ids, Sort sort) {
        return null;
    }

    @Override
    public Optional<DOMAIN> fetchById(ID id) {
        return Optional.empty();
    }

    @Override
    public DOMAIN getById(ID id) {
        return null;
    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    public DOMAIN create(DOMAIN domain) {
        return null;
    }

    @Override
    public DOMAIN update(DOMAIN domain) {
        return null;
    }

    @Override
    public DOMAIN removeById(ID id) {
        return null;
    }

    @Override
    public void remove(DOMAIN domain) {

    }
}
*/
