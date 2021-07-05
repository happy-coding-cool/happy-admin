package com.happy.admin.auth.token.granter;

import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.common.TokenRequest;
import com.happy.admin.auth.token.TokenGranter;
import cool.happycoding.code.base.exception.ExceptionFactory;

import java.util.ArrayList;
import java.util.List;

import static com.happy.admin.auth.common.AuthStatus.UNSUPPORTED_GRANT_TYPE;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 5:36 下午
 */
public class CompositeTokenGranter implements TokenGranter {

    private final List<TokenGranter> tokenGranters;

    public CompositeTokenGranter(List<TokenGranter> tokenGranters) {
        this.tokenGranters = new ArrayList<>(tokenGranters);
    }

    public void addTokenGranter(TokenGranter tokenGranter) {
        if (tokenGranter == null) {
            throw new IllegalArgumentException("Token granter is null");
        }
        tokenGranters.add(tokenGranter);
    }

    @Override
    public HappyAccessToken grant(String grantType, TokenRequest tokenRequest) {

        HappyAccessToken token = null;

        for (TokenGranter granter : tokenGranters) {
            token = granter.grant(grantType, tokenRequest);
            if (token != null) {
                return token;
            }
        }

        throw ExceptionFactory.exception(UNSUPPORTED_GRANT_TYPE);
    }
}
