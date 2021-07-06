package com.happy.admin.auth.password;

/**
 * description
 *
 * @author pengzhenchen 2021/07/06 2:12 下午
 */
public class NonePasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }
}
