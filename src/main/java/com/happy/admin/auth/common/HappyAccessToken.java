package com.happy.admin.auth.common;

import java.io.Serializable;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:03 下午
 */
public interface HappyAccessToken extends Serializable {

    String BEARER_TYPE = "Bearer";
    String ACCESS_TOKEN = "access_token";
    String TOKEN_TYPE = "token_type";
    String EXPIRES_IN = "expires_in";
    String REFRESH_TOKEN = "refresh_token";

    /**
     * token 类型
     * @return
     */
    String getTokenType();

    /**
     * token过期时间
     * @return
     */
    long getExpiresIn();

    /**
     * token 值
     * @return
     */
    String getAccessToken();

    /**
     * 获取 Refresh token
     * @return
     */
    String getRefreshToken();

}
