package com.happy.admin.auth.utils;

import com.alibaba.fastjson.util.TypeUtils;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:15 下午
 */
public class AuthUtils {

    public static String castToString(Object val){
        return TypeUtils.castToString(val);
    }
}
