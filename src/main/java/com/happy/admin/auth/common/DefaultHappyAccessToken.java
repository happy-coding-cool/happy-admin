package com.happy.admin.auth.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:07 下午
 */
@Data
@ApiModel(description = "认证信息")
public class DefaultHappyAccessToken implements HappyAccessToken{

    @ApiModelProperty("令牌")
    private String accessToken;

    @ApiModelProperty("令牌类型")
    private String tokenType;

    @ApiModelProperty("刷新令牌")
    private String refreshToken;

    @ApiModelProperty("过期时间")
    private long expiresIn;
}
