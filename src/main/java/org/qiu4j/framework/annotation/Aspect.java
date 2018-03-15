package org.qiu4j.framework.annotation;/*
 *@Author:WuRen
 *@Description:
 *@date: 15:59 2018/3/14
 */

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
