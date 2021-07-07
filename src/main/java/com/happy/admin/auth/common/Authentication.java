package com.happy.admin.auth.common;

import cool.happycoding.code.base.user.User;

import java.io.Serializable;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:30 下午
 */
public interface Authentication extends Serializable {

    /**
     * 获取凭证
     * @return
     */
    HappyPrincipal getHappyPrincipal();

    /**
     * 包装 生成 token 参数
     * @return
     */
    TokenRequest getTokenRequest();

    /**
     * 获取username
     * @return
     */
    default String getUserName(){
        HappyPrincipal principal = getHappyPrincipal();
        if (principal!=null){
            User user = principal.getUser();
            if (user!=null){
                return user.getUserName();
            }
        }
        return null;
    }

}
