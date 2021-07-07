package com.happy.admin.auth.common;

import cn.hutool.core.bean.BeanUtil;
import com.happy.admin.auth.utils.AuthUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.happy.admin.auth.common.TokenConstant.PASSWORD;
import static com.happy.admin.auth.common.TokenConstant.USERNAME;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:13 下午
 */
@Data
public class TokenRequest implements Serializable {

    /**
     * access token 有效期，单位：秒
     */
    private long accessTokenValiditySeconds;

    /**
     * refresh token 有效期，单位：秒
     */
    private long refreshTokenValiditySeconds;

    /**
     * 请求参数
     */
    private Map<String, Object> requestParameters = Collections
            .unmodifiableMap(new HashMap<>());

    public TokenRequest(){
        // 默认半小时
        this.accessTokenValiditySeconds = 30 * 60;
        // 默认1小时
        this.refreshTokenValiditySeconds = 60 * 60;
    }

    /**
     * 参数转换
     * @param authForm
     * @return
     */
    public static TokenRequest of(AuthForm authForm){
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setRequestParameters(BeanUtil.beanToMap(authForm));
        return tokenRequest;
    }

    /**
     * 获取请求验证参数
     * @param key
     * @return
     */
    public String getString(String key){
        return AuthUtils.castToString(requestParameters.get(key));
    }

    /**
     * 获取 账号
     * @return
     */
    public String getUsername(){
        return getString(USERNAME);
    }

    /**
     * 获取密码
     * @return
     */
    public String getPassword(){
        return getString(PASSWORD);
    }
}
