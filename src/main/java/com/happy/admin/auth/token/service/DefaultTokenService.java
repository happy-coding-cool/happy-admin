package com.happy.admin.auth.token.service;

import cn.hutool.core.util.IdUtil;
import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.DefaultHappyAccessToken;
import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.common.TokenRequest;
import com.happy.admin.auth.token.TokenService;
import com.happy.admin.auth.token.TokenStore;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:06 下午
 */
public class DefaultTokenService implements TokenService {

    private final TokenStore tokenStore;

    public DefaultTokenService(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public HappyAccessToken createAccessToken(Authentication authentication) {
        String accessToken = IdUtil.fastSimpleUUID();
        String refreshToken = IdUtil.fastSimpleUUID();
        DefaultHappyAccessToken token
                = DefaultHappyAccessToken.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiresIn(expireIn())
                .build();
        tokenStore.storeAccessToken(token, authentication);
        return token;
    }

    @Override
    public HappyAccessToken refreshAccessToken(String refreshToken, TokenRequest tokenRequest) {

        return null;
    }
}
