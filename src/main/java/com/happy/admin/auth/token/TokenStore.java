package com.happy.admin.auth.token;

import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.HappyAccessToken;

import java.util.Collection;

/**
 * <p>
 *     用于扩展 token 的存储方式
 * </p>
 *
 * @author pengzhenchen 2021/07/05 3:51 下午
 */
public interface TokenStore {

    /**
     * 根据access token 获取凭证信息
     * @param token
     * @return
     */
    Authentication readAuthenticationForAccessToken(String token);

    /**
     * 根据 refresh token 获取凭证信息
     * @param refreshToken
     * @return
     */
    Authentication readAuthenticationForRefreshToken(String refreshToken);


    /**
     * 根据token存储凭证
     * @param token
     * @param authentication
     */
    void storeAccessToken(HappyAccessToken token, Authentication authentication);

    /**
     * 根据 access token 读取 token信息
     * @param tokenValue
     * @return
     */
    HappyAccessToken readAccessToken(String tokenValue);

    /**
     * 删除 access token
     * @param token
     */
    void removeAccessToken(HappyAccessToken token);

    /**
     * 删除token
     * @param token
     */
    void removeAccessToken(String token);

    /**
     * 根据账号(username) 获取当前登录的用户
     * @param userName
     * @param userName
     * @return
     */
    Collection<HappyAccessToken> findTokensByUserName(String userName);


}
