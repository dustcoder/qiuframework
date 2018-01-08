package org.qiu4j.framework.bean;/*
 *@Author:WuRen
 *@Description:请求参数对象
 *@date: 19:26 2018/1/6
 */

import org.qiu4j.framework.util.CastUtil;

import java.util.Map;

public class Param {
    private Map<String,Object> paraMap;

    public Param(Map<String, Object> paraMap) {
        this.paraMap = paraMap;
    }

    public long getLong(String name){
        return CastUtil.castLong(paraMap.get(name));
    }

    public Map<String,Object> getMap(){
        return paraMap;
    }
}
