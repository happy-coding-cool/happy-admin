package com.happy.admin.auth.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

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

    @Override
    public String toString() {
        return getRefreshToken();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DefaultHappyRefreshToken)) {
            return false;
        }
        DefaultHappyRefreshToken that = (DefaultHappyRefreshToken) o;
        return Objects.equals(refreshToken, that.refreshToken);
    }

    @Override
    public int hashCode() {
        return refreshToken != null ? refreshToken.hashCode() : 0;
    }
}
