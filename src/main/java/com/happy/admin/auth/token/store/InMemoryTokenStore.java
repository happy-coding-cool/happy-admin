package com.happy.admin.auth.token.store;

import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.common.HappyAuthentication;
import com.happy.admin.auth.token.TokenStore;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:14 下午
 */
public class InMemoryTokenStore implements TokenStore {


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
