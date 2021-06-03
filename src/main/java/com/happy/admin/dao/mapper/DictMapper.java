package com.happy.admin.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.happy.admin.dao.entity.Dict;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {

}
