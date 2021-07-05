package com.happy.admin.auth.token.service;

import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.token.TokenService;
import cool.happycoding.code.base.user.User;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:06 下午
 */
public class DefaultTokenService implements TokenService {

    @Override
    public HappyAccessToken createAccessToken(User user) {
        return null;
    }
}
