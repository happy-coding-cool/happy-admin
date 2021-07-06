package com.happy.admin.auth.token;

import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.common.TokenRequest;

/**
 * <p>用于扩展token的生成方式</p>
 *
 * @author pengzhenchen 2021/07/05 3:50 下午
 */
public interface TokenService {

    /**
     * 获取access_token的有效期
     * @param validitySeconds
     * @return
     */
    default long getAccessTokenExpireIn(long validitySeconds){
        return System.currentTimeMillis() + (validitySeconds * 1000L);
    }

    /**
     * 获取refresh_token的有效期
     * @param validitySeconds
     * @return
     */
    default long getRefreshTokenValiditySeconds(long validitySeconds){
        return System.currentTimeMillis() + (validitySeconds * 1000L);
    }

    /**
     * 生成 accessToken
     * @param authentication
     * @return
     */
    HappyAccessToken createAccessToken(Authentication authentication);

    /**
     * 根据refresh token 刷新 access token
     * @param refreshToken
     * @param tokenRequest
     * @return
     */
    HappyAccessToken refreshAccessToken(String refreshToken, TokenRequest tokenRequest);

}
