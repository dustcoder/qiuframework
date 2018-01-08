package org.qiu4j.framework.util;/*
 *@Author:WuRen
 *@Description:流操作工具类
 *@date: 21:54 2018/1/8
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /*
     * @Author:WuRen
     * @Description: 从输入流中获取字符串
     * @Date: 21:57 2018/1/8
     * @param:  * @param null
    */
    public static String getString(InputStream is){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine())!=null){
                sb.append(line);
            }

        }catch (Exception e){
            LOGGER.error("get string failure",e);
            throw  new RuntimeException(e);

        }
        return sb.toString();


    }

}
