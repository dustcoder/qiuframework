package org.qiu4j.framework;/*
 *@Author:WuRen
 *@Description:
 *@date: 19:20 2018/1/6
 */

import org.qiu4j.framework.annotation.Controller;
import org.qiu4j.framework.helper.BeanHelper;
import org.qiu4j.framework.helper.ClassHelper;
import org.qiu4j.framework.helper.ControllerHelper;
import org.qiu4j.framework.helper.IocHelper;
import org.qiu4j.framework.util.ClassUtil;

public final class HelperLoader {
    public static void init(){
        Class<?> [] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for(Class<?> cls :classList){
            ClassUtil.loadClass(cls.getName(),false);
        }
    }
}
