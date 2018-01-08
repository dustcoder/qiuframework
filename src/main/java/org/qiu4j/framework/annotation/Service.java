package org.qiu4j.framework.annotation;/*
 *@Author:WuRen
 *@Description:服務類注解
 *@date: 22:51 2018/1/1
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
}
