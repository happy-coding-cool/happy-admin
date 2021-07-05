package com.happy.admin.auth.common;

import cool.happycoding.code.base.user.User;
import lombok.Data;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 5:10 下午
 */
@Data
public class HappyAuthUser implements User {

    private String userId;
    private String userName;
    private String password;
}
