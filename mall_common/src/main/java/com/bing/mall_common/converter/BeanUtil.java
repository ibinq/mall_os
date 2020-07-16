package com.bing.mall_common.converter;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/5/11 8:22
 */
public class BeanUtil {

    public static <T> T transformFrom(@Nullable Object source, @NonNull Class<T> targetClass)   {
        Assert.notNull(targetClass, "Target class must not be null");

        if (source == null) {
            return null;
        }

        try {
            T targetInstance = targetClass.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(source, targetInstance, getNullPropertyNames(source));
            return targetInstance;
        } catch (Exception e) {
            throw new RuntimeException("",e);
        }

    }

    private static String[] getNullPropertyNames(@NonNull Object source) {
        return getNullPropertyNameSet(source).toArray(new String[0]);
    }

    private static Set<String> getNullPropertyNameSet(@NonNull Object source) {

        Assert.notNull(source, "source object must not be null");
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(source);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String propertyName = propertyDescriptor.getName();
            Object propertyValue = beanWrapper.getPropertyValue(propertyName);

            if (propertyValue == null) {
                emptyNames.add(propertyName);
            }
        }

        return emptyNames;
    }

    public static void updateProperties(@NonNull Object source, @NonNull Object target) {
        Assert.notNull(source, "source object must not be null");
        Assert.notNull(target, "target object must not be null");

        // Set non null properties from source properties to target properties

        org.springframework.beans.BeanUtils.copyProperties(source, target, getNullPropertyNames(source));

    }
}
