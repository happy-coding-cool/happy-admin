package com.happy.admin.auth.token.granter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.HappyAuthUser;
import com.happy.admin.auth.common.HappyAuthentication;
import com.happy.admin.auth.common.TokenRequest;
import com.happy.admin.auth.password.PasswordEncoder;
import com.happy.admin.auth.token.TokenService;
import com.happy.admin.auth.service.AuthUserService;

import static com.happy.admin.auth.common.AuthStatus.INVALID_PASSWORD;
import static com.happy.admin.auth.common.AuthStatus.NO_USER;
import static com.happy.admin.auth.common.TokenConstant.GRANT_TYPE_PWD;
import static cool.happycoding.code.base.util.HappyCodeUtil.check;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:25 下午
 */
public class PasswordTokenGranter extends AbstractTokenGranter {

    private final AuthUserService authUserService;
    private final PasswordEncoder passwordEncoder;

    public PasswordTokenGranter(TokenService tokenService, AuthUserService authUserService, PasswordEncoder passwordEncoder) {
        super(tokenService);
        this.authUserService = authUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication loadAuthentication(TokenRequest tokenRequest) {
        String username = tokenRequest.getUsername();
        String password = tokenRequest.getPassword();
        HappyAuthUser user = authUserService.obtainAuthUserByUsername(username);
        check(ObjectUtil.isNull(user), NO_USER);
        check(!passwordEncoder.matches(password, user.getPassword()), INVALID_PASSWORD);
        return HappyAuthentication.of(user, tokenRequest);
    }

    @Override
    public boolean validateGrantType(String grantType) {
        return StrUtil.equalsAnyIgnoreCase(GRANT_TYPE_PWD, grantType);
    }
}
