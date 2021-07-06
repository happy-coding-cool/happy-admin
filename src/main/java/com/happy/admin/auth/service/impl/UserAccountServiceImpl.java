package com.happy.admin.auth.service.impl;

import com.happy.admin.auth.common.HappyAuthUser;
import com.happy.admin.auth.dao.mapper.AuthUserMapper;
import com.happy.admin.auth.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author pengzhenchen 2021/07/06 1:47 下午
 */
@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final AuthUserMapper authUserMapper;

    @Override
    public HappyAuthUser obtainAuthUserByUsername(String username) {
        return authUserMapper.selectUserByAccount(username);
    }
}
