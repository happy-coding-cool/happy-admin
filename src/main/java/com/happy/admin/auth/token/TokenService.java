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
