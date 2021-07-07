package com.happy.admin.auth.token.store;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.token.TokenStore;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:14 下午
 */
public class InMemoryTokenStore implements TokenStore {

    private final ConcurrentHashMap<String, HappyAccessToken> accessTokenStore = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Authentication> accessTokenAuthenticationStore = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Authentication> refreshTokenAuthenticationStore = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Collection<HappyAccessToken>> userNameToAccessTokenStore = new ConcurrentHashMap<>();

    @Override
    public Authentication readAuthenticationForAccessToken(String token) {
        return accessTokenAuthenticationStore.get(token);
    }

    @Override
    public Authentication readAuthenticationForRefreshToken(String refreshToken) {
        return refreshTokenAuthenticationStore.get(refreshToken);
    }

    @Override
    public void storeAccessToken(HappyAccessToken token, Authentication authentication) {
        accessTokenStore.put(token.getAccessToken(), token);
        accessTokenAuthenticationStore.put(token.getAccessToken(), authentication);
        if (existsRefreshToken(token)) {
            refreshTokenAuthenticationStore.put(token.getRefreshToken().getRefreshToken(), authentication);
        }
        addToCollection(token, authentication);
    }

    private void addToCollection(HappyAccessToken token, Authentication authentication){
        String key = authentication.getUserName();
        if (StrUtil.isNotBlank(key)) {
            if (!userNameToAccessTokenStore.containsKey(key)) {
                synchronized (userNameToAccessTokenStore) {
                    if (!userNameToAccessTokenStore.containsKey(key)) {
                        userNameToAccessTokenStore.put(key, new HashSet<>());
                    }
                }
            }
            userNameToAccessTokenStore.get(key).add(token);
        }
    }

    @Override
    public HappyAccessToken readAccessToken(String tokenValue) {
        HappyAccessToken accessToken = accessTokenStore.get(tokenValue);
        if (ObjectUtil.isNotNull(accessToken)){
            if (System.currentTimeMillis() > accessToken.getExpiresIn()){
                // token 已过期，删除缓存的token
                removeAccessToken(tokenValue);
            }
        }
        return accessToken;
    }

    @Override
    public void removeAccessToken(HappyAccessToken token) {
        removeAccessToken(token.getAccessToken());
    }

    @Override
    public void removeAccessToken(String tokenValue){

        HappyAccessToken removed = accessTokenStore.remove(tokenValue);
        Authentication authentication = accessTokenAuthenticationStore.remove(tokenValue);
        if (existsRefreshToken(removed)){
            refreshTokenAuthenticationStore.remove(removed.getRefreshToken().getRefreshToken());
        }
        userNameToAccessTokenStore.get(authentication.getUserName()).remove(removed);
    }

    private boolean existsRefreshToken(HappyAccessToken token){
        return ObjectUtil.isNotNull(token.getRefreshToken())
                && ObjectUtil.isNotNull(token.getRefreshToken().getRefreshToken());
    }

    @Override
    public Collection<HappyAccessToken> findTokensByUserName(String userName) {
        return userNameToAccessTokenStore.get(userName);
    }
}
