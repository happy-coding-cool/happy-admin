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

    public static HappyAuthentication of(HappyAuthUser user){
        HappyAuthentication authentication = new HappyAuthentication();
        // 为了安全抹除：密码
        user.setPassword(null);
        authentication.setHappyPrincipal(new HappyPrincipal(user));
        return authentication;
    }
}
