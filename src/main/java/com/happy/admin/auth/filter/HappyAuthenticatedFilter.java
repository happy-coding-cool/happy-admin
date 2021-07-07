package com.happy.admin.auth.filter;

import cn.hutool.core.util.StrUtil;
import com.happy.admin.auth.common.Authentication;
import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.token.TokenStore;
import cool.happycoding.code.base.user.User;
import cool.happycoding.code.user.wrapper.HttpServletRequestHeaderWrapper;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.happy.admin.auth.common.AuthStatus.INVALID_TOKEN;
import static com.happy.admin.auth.common.AuthStatus.NO_TOKEN;
import static com.happy.admin.auth.common.TokenConstant.*;
import static cool.happycoding.code.base.util.HappyCodeUtil.check;

/**
 * description
 *
 * @author pengzhenchen 2021/07/07 8:39 上午
 */
public class HappyAuthenticatedFilter extends AbstractAuthenticatedFilter {

    private final TokenStore tokenStore;

    private final int order;

    public HappyAuthenticatedFilter(List<String> skipUrls, TokenStore tokenStore, int order) {
        super(skipUrls);
        this.tokenStore = tokenStore;
        this.order = order;
    }

    @Override
    protected void doAuthenticate(HttpServletRequestHeaderWrapper request, HttpServletResponse response) {

        // 验证状态
        String token = StrUtil.blankToDefault(request.getHeader(AUTHORIZATION),
                request.getParameter(PARAM_ACCESS_TOKEN));

        // 校验token不能为空
        check(StrUtil.isBlank(token), NO_TOKEN);
        if (token.startsWith(BEARER)) {
            token = StrUtil.trim(StrUtil.removeAll(token, BEARER));
        }

        HappyAccessToken happyAccessToken = tokenStore.readAccessToken(token);
        // 校验状态是否过期
        check(System.currentTimeMillis() > happyAccessToken.getExpiresIn(), INVALID_TOKEN);
        Authentication authentication = tokenStore.readAuthenticationForAccessToken(token);
        User user = authentication.getHappyPrincipal().getUser();
        // 往请求头里设置header字段
        request.addHeader(USER_ID, user.getUserId());
    }

    @Override
    public int getOrder() {
        return order;
    }
}
