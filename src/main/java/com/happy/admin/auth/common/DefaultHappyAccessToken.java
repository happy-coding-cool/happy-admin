package com.happy.admin.auth.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Map;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:07 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "认证信息")
public class DefaultHappyAccessToken implements HappyAccessToken{

    @ApiModelProperty("令牌")
    private String accessToken;

    @ApiModelProperty("令牌类型")
    private String tokenType;

    @ApiModelProperty("刷新令牌")
    private HappyRefreshToken refreshToken;

    @ApiModelProperty("过期时间")
    private long expiresIn;

    /**
     * 附加信息
     */
    private Map<String, Object> additionalInformation = Collections.emptyMap();


    @Override
    public boolean equals(Object obj) {
        return obj != null && toString().equals(obj.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(getAccessToken());
    }
}
