package com.happy.admin.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.happy.admin.dao.entity.UserRole;

/**
 * <p>
 * 用户角色关系 Mapper 接口
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
