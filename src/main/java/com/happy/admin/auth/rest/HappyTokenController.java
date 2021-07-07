package com.happy.admin.auth.rest;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.happy.admin.auth.common.AuthForm;
import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.common.TokenRequest;
import com.happy.admin.auth.token.TokenGranter;
import com.happy.admin.auth.token.TokenStore;
import cool.happycoding.code.base.result.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.happy.admin.auth.common.TokenConstant.GRANT_TYPE_PWD;

/**
 * description
 *
 * @author lanlanhappy 2021/07/05 8:48 上午
 */
@Slf4j
@Api(tags = "登陆认证")
@RestController
@RequiredArgsConstructor
@RequestMapping("happy/auth")
public class HappyTokenController {

    private final TokenStore tokenStore;
    private final TokenGranter tokenGranter;


    @PostMapping("token")
    @ApiOperation(value = "登录认证", notes = "登录认证")
    public BaseResult<HappyAccessToken> token(@Valid @RequestBody AuthForm authForm){
        // 当grantType为空时，设置为：password
        authForm.setGrantType(StrUtil.blankToDefault(authForm.getGrantType(), GRANT_TYPE_PWD));
        return BaseResult.success(tokenGranter.grant(authForm.getGrantType(), TokenRequest.of(authForm)));
    }


    @GetMapping("revoke")
    @ApiOperation(value = "注销token", notes = "注销token")
    public BaseResult<Boolean> revoke(String token){
        // 注销token
        tokenStore.removeAccessToken(token);
        return BaseResult.success(Boolean.TRUE);
    }


    @GetMapping("check")
    @ApiOperation(value = "校验token", notes = "校验token")
    public BaseResult<Boolean> check(String token){
        HappyAccessToken accessToken = tokenStore.readAccessToken(token);
        return BaseResult.success(ObjectUtil.isNotNull(accessToken)
                && accessToken.getExpiresIn() > System.currentTimeMillis());
    }


}
