package com.happy.admin.sys.dao.mapper;

import com.happy.admin.auth.common.HappyAuthUser;
import com.happy.admin.sys.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author happycoding
 * @since 2021-05-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    HappyAuthUser selectUserByAccount(String account);
}
