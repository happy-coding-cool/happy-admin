package com.happy.admin.auth.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:07 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DefaultHappyRefreshToken implements HappyRefreshToken{

    private String refreshToken;
    private long expireIn;
}
