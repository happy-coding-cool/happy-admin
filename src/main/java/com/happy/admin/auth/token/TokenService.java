package com.happy.admin.auth.token;

import com.happy.admin.auth.common.HappyAccessToken;
import cool.happycoding.code.base.user.User;

/**
 * <p>用于扩展token的生成方式</p>
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
