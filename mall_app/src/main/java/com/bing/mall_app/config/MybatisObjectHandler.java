package com.bing.mall_app.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/8 10:05
 */
@Slf4j
@Component
public class MybatisObjectHandler implements MetaObjectHandler {

    //插入时的填充出的略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("star insert fill...");
        //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("createTime", LocalDateTime.now(),metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(),metaObject);
        this.setFieldValByName("deleted",0,metaObject);
    }
    //更新时填充
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("star update fill...");
        //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("updateTime",LocalDateTime.now(),metaObject);
    }

}
