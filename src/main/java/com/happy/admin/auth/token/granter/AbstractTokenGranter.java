package com.happy.admin.auth.token.granter;

import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.common.TokenRequest;
import com.happy.admin.auth.token.TokenGranter;
import com.happy.admin.auth.token.TokenService;
import lombok.Data;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:50 下午
 */
@Data
public abstract class AbstractTokenGranter implements TokenGranter {

    private final TokenService tokenService;

    public AbstractTokenGranter(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @Override
    public HappyAccessToken grant(String grantType, TokenRequest tokenRequest) {
        return tokenService.createAccessToken(getUserDetail(tokenRequest));
    }

    /**
     * 获取待验证的用户信息
     * @param tokenRequest
     * @return
     */
    public abstract Authentication getUserDetail(TokenRequest tokenRequest);
}
