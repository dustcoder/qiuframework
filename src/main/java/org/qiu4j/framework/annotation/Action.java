package org.qiu4j.framework.annotation;/*
 *@Author:WuRen
 *@Description:action方法注解
 *@date: 22:49 2018/1/1
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {

    /*
     * @Author:WuRen
     * @Description: 請求類型與路徑
     * @Date: 22:50 2018/1/1  
     * @param:  * @param null
    */
    String value();
}
