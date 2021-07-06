package com.happy.admin.auth.token.store;

import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.common.HappyAuthentication;
import com.happy.admin.auth.token.TokenStore;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:14 下午
 */
public class InMemoryTokenStore implements TokenStore {

    private final ConcurrentHashMap<String, HappyAccessToken> accessTokenStore = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Authentication> authenticationStore = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, HappyAccessToken> authenticationToAccessTokenStore = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Collection<HappyAccessToken>> userNameToAccessTokenStore = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, String> refreshTokenToAccessTokenStore = new ConcurrentHashMap<String, String>();
    private final ConcurrentHashMap<String, String> accessTokenToRefreshTokenStore = new ConcurrentHashMap<String, String>();

    @Override
    public HappyAuthentication readAuthentication(HappyAccessToken token) {
        return null;
    }

    @Override
    public HappyAuthentication readAuthentication(String token) {
        return null;
    }

    @Override
    public void storeAccessToken(HappyAccessToken token, Authentication authentication) {

    }

    @Override
    public HappyAccessToken readAccessToken(String tokenValue) {
        return null;
    }

    @Override
    public HappyAuthentication readAuthenticationForRefreshToken(String refreshToken) {
        return null;
    }
}
