package com.happy.admin.auth.user;

import com.happy.admin.auth.common.HappyAuthUser;

/**
 * description
 *
 * @author pengzhenchen 2021/07/06 1:42 下午
 */
public interface AuthUserService {

    /**
     * 获取需要认证的user信息
     * @param username
     * @return
     */
    HappyAuthUser obtainAuthUserByUsername(String username);
}
