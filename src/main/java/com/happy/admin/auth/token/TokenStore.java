package com.happy.admin.auth.token;

import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.common.HappyAuthentication;

/**
 * <p>
 *     用于扩展 token 的存储方式
 * </p>
 *
 * @author pengzhenchen 2021/07/05 3:51 下午
 */
public interface TokenStore {

    /**
     * 根据 token 获取凭证
     * @param token
     * @return
     */
    HappyAuthentication readAuthentication(HappyAccessToken token);

    /**
     * 根据access token获取凭证
     * @param token
     * @return
     */
    HappyAuthentication readAuthentication(String token);

    /**
     * 根据token存储凭证
     * @param token
     * @param authentication
     */
    void storeAccessToken(HappyAccessToken token, Authentication authentication);

    /**
     * 根据 token val 读取 token信息
     * @param tokenValue
     * @return
     */
    HappyAccessToken readAccessToken(String tokenValue);

    /**
     * 根据 refresh token 读取 凭证信息
     * @param refreshToken
     * @return
     */
    HappyAuthentication readAuthenticationForRefreshToken(String refreshToken);

}
