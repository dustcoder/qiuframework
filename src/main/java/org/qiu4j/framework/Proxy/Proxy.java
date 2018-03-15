package org.qiu4j.framework.Proxy;/*
 *@Author:WuRen
 *@Description:
 *@date: 16:03 2018/3/14
 */

public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
