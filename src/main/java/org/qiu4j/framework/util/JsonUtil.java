package org.qiu4j.framework.util;/*
 *@Author:WuRen
 *@Description:JSON工具类
 *@date: 21:30 2018/1/8
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> String toJson(T obj){
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        }catch (Exception e){
            LOGGER.error("convert object to json failure",e);
            throw new RuntimeException(e);
        }
        return json;


    }

    public static <T> T fromJson(String json,Class<T> type){
        T pojo;
        try {
            pojo = OBJECT_MAPPER.readValue(json,type);
        }catch (Exception e){
            LOGGER.error("convert json to object failure",e);
            throw new RuntimeException(e);
        }
        return pojo;

    }



}
