/*
package com.bing.mall_common.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

*/
/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/18 8:58
 *//*

public interface CrudService<DOMAIN,ID> {

    */
/**
     * 查询所有
     * @return
     *//*

    List<DOMAIN> listAll();

    */
/**
     * 根据字段排序
     * @param column 排序字段
     * @param isAsc
     * @return
     *//*

    List<DOMAIN> listAll(@NonNull String column, @NonNull  boolean isAsc);

    */
/**
     * 获取分页列表
     * @param pageable
     * @return
     *//*

    Page<DOMAIN> listAll(Integer pageNum , Integer pageSize);

    */
/**
     *获取id返回列表
     * @param ids
     * @return
     *//*

    List<DOMAIN> listAllByIds(@Nullable Collection<ID> ids);

    */
/**
     *
     * @param ids
     * @param sort
     * @return
     *//*

    List<DOMAIN> listAllByIds(@Nullable Collection<ID> ids, @NonNull Sort sort);

    */
/**
     *
     * @param id
     * @return
     *//*

    Optional<DOMAIN> fetchById(@NonNull ID id);

    DOMAIN getById(@NonNull ID id);

    boolean existsById(@NonNull ID id);

    DOMAIN create(@NonNull DOMAIN domain);

    DOMAIN update(@NonNull DOMAIN domain);

    DOMAIN removeById(@NonNull ID id);

    void remove(@NonNull DOMAIN domain);
}
*/
