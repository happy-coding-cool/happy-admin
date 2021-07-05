package com.happy.admin.auth.token.granter;

import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.HappyAuthUser;
import com.happy.admin.auth.common.HappyAuthentication;
import com.happy.admin.auth.common.TokenRequest;
import com.happy.admin.auth.password.PasswordEncoder;
import com.happy.admin.auth.token.TokenService;
import cool.happycoding.code.base.user.User;
import cool.happycoding.code.base.user.UserContextService;

import static com.happy.admin.auth.common.AuthStatus.INVALID_PASSWORD;
import static cool.happycoding.code.base.util.HappyCodeUtil.check;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:25 下午
 */
public class PasswordTokenGranter extends AbstractTokenGranter {

    private final UserContextService userContextService;
    private final PasswordEncoder passwordEncoder;

    public PasswordTokenGranter(TokenService tokenService, UserContextService userContextService, PasswordEncoder passwordEncoder) {
        super(tokenService);
        this.userContextService = userContextService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication loadAuthentication(TokenRequest tokenRequest) {
        String username = tokenRequest.getUsername();
        String password = tokenRequest.getPassword();
        User user = userContextService.loadUserDetail(username);
        check(passwordEncoder.matches(password, user.getPassword()), INVALID_PASSWORD);
        return HappyAuthentication.of((HappyAuthUser) user);
    }

}
