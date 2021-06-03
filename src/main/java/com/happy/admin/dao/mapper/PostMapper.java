package com.happy.admin.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.happy.admin.dao.entity.Post;

/**
 * <p>
 * 岗位 Mapper 接口
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {

}
