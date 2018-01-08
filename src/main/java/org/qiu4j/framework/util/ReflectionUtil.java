package org.qiu4j.framework.util;/*
 *@Author:WuRen
 *@Description:反射工具类
 *@date: 20:40 2018/1/2
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ReflectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    public static Object newInstance(Class<?> cls){
        Object instance;
        try {
            instance = cls.newInstance();
        }catch (Exception e){
            LOGGER.error("new instance failure",e);
            throw new RuntimeException(e);
        }
        return instance;

    }

    public static Object invokeMethod(Object obj, Method method,Object ...args){
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj,args);
        }catch (Exception e){
            LOGGER.error("invoke methos failure",e);
            throw new RuntimeException(e);
        }

        return result;
    }

    /*
     * @Author:WuRen
     * @Description: 设置成员变量的值
     * @Date: 20:51 2018/1/2
     * @param:  * @param null
    */
    public static void setFiled(Object obj, Field field, Object value){
        try {
            field.setAccessible(true);
            field.set(obj,value);
        }catch (Exception e){
            LOGGER.error("set filed failure",e);
            throw new RuntimeException(e);
        }
    }

}
