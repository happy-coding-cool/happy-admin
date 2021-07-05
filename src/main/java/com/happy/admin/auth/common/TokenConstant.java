package com.happy.admin.auth.common;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 5:25 下午
 */
public interface TokenConstant {

    /**
     * user info
     */
    String USERNAME = "username";
    String PASSWORD = "password";

    String BEARER_TYPE = "Bearer";
    String ACCESS_TOKEN = "accessToken";
    String TOKEN_TYPE = "tokenType";
    String EXPIRES_IN = "expiresIn";
    String REFRESH_TOKEN = "refreshToken";


    /**
     * grant_type
     */
    String GRANT_TYPE_REFRESH_TOKEN  = "refresh_token";
    String GRANT_TYPE_PWD   = "password";
}
