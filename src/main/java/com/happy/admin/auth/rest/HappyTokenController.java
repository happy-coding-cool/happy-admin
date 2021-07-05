package com.happy.admin.auth.rest;

import com.happy.admin.auth.common.AuthForm;
import com.happy.admin.auth.common.HappyAccessToken;
import com.happy.admin.auth.common.TokenRequest;
import com.happy.admin.auth.token.TokenGranter;
import cool.happycoding.code.base.result.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    private final TokenGranter tokenGranter;

    @PostMapping("token")
    @ApiOperation(value = "登录认证", notes = "登录认证")
    public BaseResult<HappyAccessToken> token(@Valid @RequestBody AuthForm authForm){
        return BaseResult.success(tokenGranter.grant(authForm.getGrantType(), TokenRequest.of(authForm)));
    }


    @GetMapping("revoke")
    @ApiOperation(value = "注销token", notes = "注销token")
    public BaseResult<Boolean> revoke(String token){
        // TODO 注销token
        return BaseResult.success(Boolean.TRUE);
    }


    @GetMapping("check")
    @ApiOperation(value = "校验token", notes = "校验token")
    public BaseResult<Boolean> check(String token){
        // TODO 校验token
        return BaseResult.success(Boolean.TRUE);
    }


}
