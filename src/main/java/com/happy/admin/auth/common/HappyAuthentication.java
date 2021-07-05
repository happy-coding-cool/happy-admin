package com.happy.admin.auth.common;

import cool.happycoding.code.base.user.User;
import lombok.Data;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:30 下午
 */
@Data
public class HappyAuthentication implements Authentication {

    private HappyPrincipal happyPrincipal;

    public static HappyAuthentication of(User user){
        HappyAuthentication authentication = new HappyAuthentication();
        authentication.setHappyPrincipal(new HappyPrincipal(user));
        return authentication;
    }
}
