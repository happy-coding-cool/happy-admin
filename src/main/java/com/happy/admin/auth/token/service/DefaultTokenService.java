package com.happy.admin.auth.token.service;

import cn.hutool.core.util.IdUtil;
import com.happy.admin.auth.common.*;
import com.happy.admin.auth.token.TokenService;
import com.happy.admin.auth.token.TokenStore;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:06 下午
 */
@SuppressWarnings("all")
public class DefaultTokenService implements TokenService {

    private final TokenStore tokenStore;

    public DefaultTokenService(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public HappyAccessToken createAccessToken(Authentication authentication) {
        String accessToken = IdUtil.fastSimpleUUID();
        String refreshToken = IdUtil.fastSimpleUUID();
        TokenRequest tokenRequest = authentication.getTokenRequest();
        DefaultHappyAccessToken token
                = DefaultHappyAccessToken.builder()
                .accessToken(accessToken)
                .refreshToken(new DefaultHappyRefreshToken(refreshToken,
                        getRefreshTokenValiditySeconds(tokenRequest.getRefreshTokenValiditySeconds())))
                .expiresIn(getAccessTokenExpireIn(tokenRequest.getAccessTokenValiditySeconds()))
                .build();
        tokenStore.storeAccessToken(token, authentication);
        return token;
    }

    @Override
    public HappyAccessToken refreshAccessToken(String refreshToken, TokenRequest tokenRequest) {

        return null;
    }
}
