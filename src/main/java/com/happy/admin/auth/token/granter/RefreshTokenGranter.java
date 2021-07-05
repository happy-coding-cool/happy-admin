package com.happy.admin.auth.token.granter;

import com.happy.admin.auth.common.TokenRequest;
import com.happy.admin.auth.token.TokenService;
import cool.happycoding.code.base.user.User;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:20 下午
 */
public class RefreshTokenGranter extends AbstractTokenGranter{


    public RefreshTokenGranter(TokenService tokenService) {
        super(tokenService);
    }

    @Override
    public User getUserDetail(TokenRequest tokenRequest) {

        return null;
    }

}
