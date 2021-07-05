package com.happy.admin.auth.token.granter;

import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.common.TokenRequest;
import com.happy.admin.auth.token.TokenGranter;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:25 下午
 */
public class PasswordTokenGranter implements TokenGranter {

    @Override
    public HappyAccessToken grant(String grantType, TokenRequest tokenRequest) {
        return null;
    }

}
