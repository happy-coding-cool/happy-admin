package com.happy.admin.auth.common;
import lombok.Data;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:30 下午
 */
@Data
public class HappyAuthentication implements Authentication {

    private HappyPrincipal happyPrincipal;

    private TokenRequest tokenRequest;

    public static HappyAuthentication of(HappyAuthUser user, TokenRequest tokenRequest){
        HappyAuthentication authentication = new HappyAuthentication();
        // 为了安全抹除：密码
        user.setPassword(null);
        authentication.setHappyPrincipal(new HappyPrincipal(user));
        authentication.setTokenRequest(tokenRequest);
        return authentication;
    }
}
