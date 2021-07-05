package com.happy.admin.auth.password;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * description
 *
 * @author pengzhenchen 2021/07/05 4:01 下午
 */
public class Md5PasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence rawPassword) {
        return DigestUtil.md5Hex(rawPassword.toString());
    }
}
