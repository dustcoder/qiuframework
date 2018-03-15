package org.qiu4j.framework.annotation;/*
 *@Author:WuRen
 *@Description:
 *@date: 22:51 2018/1/1
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}
