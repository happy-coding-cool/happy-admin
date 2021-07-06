package com.happy.admin.auth.dao.mapper;

import com.happy.admin.auth.common.HappyAuthUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * description
 *
 * @author pengzhenchen 2021/07/06 2:17 下午
 */
@Mapper
public interface AuthUserMapper {

    /**
     * 根据账号查询用户信息
     * @param account
     * @return
     */
    HappyAuthUser selectUserByAccount(String account);

}
