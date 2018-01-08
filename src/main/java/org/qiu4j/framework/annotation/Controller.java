package org.qiu4j.framework.annotation;/*
 *@Author:WuRen
 *@Description:
 *@date: 22:48 2018/1/1
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Author:WuRen
 * @Description: 控制器注解
 * @Date: 22:49 2018/1/1
 * @param:  * @param null
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
