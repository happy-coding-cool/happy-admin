package com.happy.admin.auth.password;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:08 下午
 */
public class Sha256PasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence rawPassword) {
        return DigestUtil.sha256Hex(rawPassword.toString());
    }
}
