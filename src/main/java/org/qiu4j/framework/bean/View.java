package org.qiu4j.framework.bean;/*
 *@Author:WuRen
 *@Description:视图对象
 *@date: 19:36 2018/1/6
 */

import java.util.Map;

public class View {
    //视图路径
    private String path;
    //模型数据
    private Map<String,Object> model;

    public View(String path, Map<String, Object> model) {
        this.path = path;
        this.model = model;
    }

    public  View(String path){
        this.path = path;
    }
    public View addModel(String key,Object value){
        model.put(key,value);
        return this;
    }
    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
