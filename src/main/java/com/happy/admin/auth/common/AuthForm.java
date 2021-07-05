package com.happy.admin.auth.common;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 3:11 下午
 */
@Data
public class AuthForm implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
    /**
     * 授权类型，默认为： password
     */
    private String grantType;

    /**
     * 当 grantType为refreshToken时，该值不能为空
     */
    private String refreshToken;


}
