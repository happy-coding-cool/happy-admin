package com.happy.admin.auth.common;

import cool.happycoding.code.base.common.ResultCode;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:04 下午
 */
public enum AuthStatus implements ResultCode {

    /**
     * 没有token invalid
     */
    NO_TOKEN("401", "token不能为空！"),
    INVALID_TOKEN("401", "无效的token！"),
    INVALID_PASSWORD("invalid_password", "密码错误"),
    ACCOUNT_OR_PWD_INVALID("401","账号或密码错误"),
    UNSUPPORTED_GRANT_TYPE("401","不支持的授权类型"),
    AUTH_FAIL("auth_fail", "登录认证失败！！！"),
    CREATE_FAIL("create_fail", "用户创建失败！！！"),
    PERMISSION_DENIED("Permission denied", "没有访问权限"),
    NO_USER("user does not exist", "用户不存在"),
    ACCOUNT_ALREADY_EXISTS("Account already exists", "账号已存在"),
    USER_INVALID("user invalid", "用户失效"),
    ACCOUNT_NOT_NULL("400","用户名不能为空！"),
    PASSWORD_NOT_NULL("400","密码不能为空！"),
    WEBHOOK_ILLEGAL_REQUEST("illegal request", "webhook 非法请求"),

    ;

    String code;
    String message;

    AuthStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
