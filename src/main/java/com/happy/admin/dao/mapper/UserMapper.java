package com.happy.admin.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.happy.admin.dao.entity.User;

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

}
