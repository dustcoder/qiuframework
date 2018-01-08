package org.qiu4j.framework.util;/*
 *@Author:WuRen
 *@Description:
 *@date: 23:57 2018/1/5
 */

import org.apache.commons.lang3.ArrayUtils;

public final class ArrayUtil {


    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }

    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }
}
