package com.happy.admin.auth.token;

import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.common.TokenRequest;

/**
 * <p> token </p>
 *
 * @author pengzhenchen 2021/07/05 2:59 下午
 */
public interface TokenGranter {

    /**
     * 生成token
     * @param grantType
     * @param tokenRequest
     * @return
     */
    HappyAccessToken grant(String grantType, TokenRequest tokenRequest);

    /**
     * 验证授权类型
     * @param grantType
     * @return
     */
    default boolean validateGrantType(String grantType){
        return true;
    }
}
