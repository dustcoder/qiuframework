package org.qiu4j.framework.aspect;/*
 *@Author:WuRen
 *@Description:拦截controller方法
 *@date: 16:55 2018/3/14
 */

import org.qiu4j.framework.Proxy.AspectProxy;
import org.qiu4j.framework.Proxy.ProxyChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;


public class ControllerAspect extends AspectProxy{
    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    public void before(Class<?> cls, Method method,Object[] params)throws Throwable{
        logger.debug("---------begin----------");
        logger.debug(String.format("class: %s",cls.getName()));
        logger.debug(String.format("method: %s",method.getName()));
        begin = System.currentTimeMillis();
    }

    public void  after()throws Throwable{
        logger.debug(String.format("time: %dms",System.currentTimeMillis() - begin));
        logger.debug("----------end------------");
    }
}
