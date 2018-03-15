package org.qiu4j.framework.helper;/*
 *@Author:WuRen
 *@Description:類操作助手類
 *@date: 20:27 2018/1/2
 */

import org.qiu4j.framework.annotation.Controller;
import org.qiu4j.framework.annotation.Service;
import org.qiu4j.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

public final class ClassHelper {
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }
/*
 * @Author:WuRen
 * @Description: 获取应用包名下的service 类
 * @Date: 20:35 2018/1/2  
 * @param:  * @param null
*/
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls:CLASS_SET){
            if(cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }

        }
        return classSet;
    }

    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls:CLASS_SET){
            if(cls.isAnnotationPresent(Controller.class)){
                classSet.add(cls);
            }

        }
        return classSet;
    }


    /*
     * @Author:WuRen
     * @Description: 获取应用包名下的所有bean类
     * @Date: 20:37 2018/1/2
     * @param:  * @param null
    */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }

    /*
     * @Author:WuRen
     * @Description:
     * @Date: 2018/3/15
     * @param:  * @param superClass
     */
    public static Set<Class<?>> getClassSetBySuper(Class <?> superClass){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls: CLASS_SET){
            if(superClass.isAssignableFrom(cls) && !superClass.equals(cls)){
                classSet.add(cls);
            }
        }
        return  classSet;
    }

    /*
     * @Author:WuRen
     * @Description:获取应用包名下带有某注解的所有类
     * @Date: 14:41 2018/3/15
     * @param:  * @param annotationClass
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass){

        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls: CLASS_SET){
            if(cls.isAnnotationPresent(annotationClass)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

}
