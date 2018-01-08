package org.qiu4j.framework.bean;/*
 *@Author:WuRen
 *@Description:封装action信息
 *@date: 0:07 2018/1/6
 */

import java.lang.reflect.Method;

public class Handler {
    private Class<?> controllerClass;
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
