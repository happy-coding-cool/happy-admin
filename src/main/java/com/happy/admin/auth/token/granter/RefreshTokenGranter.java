package com.happy.admin.auth.token.granter;

import cn.hutool.core.util.StrUtil;
import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.TokenRequest;
import com.happy.admin.auth.token.TokenService;
import com.happy.admin.auth.token.TokenStore;

import static com.happy.admin.auth.common.TokenConstant.GRANT_TYPE_REFRESH_TOKEN;
import static com.happy.admin.auth.common.TokenConstant.REFRESH_TOKEN;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:20 下午
 */
public class RefreshTokenGranter extends AbstractTokenGranter {

    private final TokenStore tokenStore;

    public RefreshTokenGranter(TokenService tokenService, TokenStore tokenStore) {
        super(tokenService);
        this.tokenStore = tokenStore;
    }

    @Override
    public Authentication loadAuthentication(TokenRequest tokenRequest) {
        return tokenStore.readAuthenticationForRefreshToken(tokenRequest.getString(REFRESH_TOKEN));
    }

    @Override
    public boolean validateGrantType(String grantType) {
        return StrUtil.equalsAnyIgnoreCase(GRANT_TYPE_REFRESH_TOKEN, grantType);
    }
}
