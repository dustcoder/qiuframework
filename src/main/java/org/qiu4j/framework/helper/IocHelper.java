package org.qiu4j.framework.helper;/*
 *@Author:WuRen
 *@Description:
 *@date: 23:39 2018/1/5
 */

import org.qiu4j.framework.annotation.Inject;
import org.qiu4j.framework.util.CollectionUtil;
import org.qiu4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

public final class IocHelper {
    static {
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if(CollectionUtil.isNotEmpty(beanMap)){
            for(Map.Entry<Class<?>,Object> beanEntry:beanMap.entrySet()){
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取bean 类定义的所有成员变量
                Field [] fields = beanClass.getDeclaredFields();
                for(Field field:fields){
                    //判断当前bean field是否带有inject注解
                    if (field.isAnnotationPresent(Inject.class)){
                        //在beanMap中 获取bean field对应实例
                        Class <?> beanFieldClass = field.getType();
                        Object beanFieldInstance = beanMap.get(beanFieldClass);
                        if(beanFieldInstance != null){
                            ReflectionUtil.setFiled(beanInstance,field,beanFieldInstance);
                        }
                    }

                }

            }

        }
    }
}
