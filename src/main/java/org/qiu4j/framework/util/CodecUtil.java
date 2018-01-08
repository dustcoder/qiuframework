package org.qiu4j.framework.util;/*
 *@Author:WuRen
 *@Description:编码与解码操作工具类
 *@date: 21:23 2018/1/8
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

public final class CodecUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    public static String encodeURL(String source){
        String target;
        try {
            target = URLEncoder.encode(source,"UTF-8");
        }catch (Exception e){
            LOGGER.error("encode url failure",e);
            throw  new RuntimeException(e);
        }
        return target;
    }


    public static String decodeURL(String source){
        String target;
        try {
            target = URLDecoder.decode(source,"UTF-8");
        }catch (Exception e){
            LOGGER.error("decode url failure",e);
            throw  new RuntimeException(e);
        }
        return target;
    }



}
