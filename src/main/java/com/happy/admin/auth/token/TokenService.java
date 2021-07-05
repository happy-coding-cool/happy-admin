package com.happy.admin.auth.token;

import com.happy.admin.auth.common.HappyAccessToken;
import cool.happycoding.code.base.user.User;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:50 下午
 */
public interface TokenService {

    /**
     * 生成 accessToken
     * @param user
     * @return
     */
    HappyAccessToken createAccessToken(User user);

}
