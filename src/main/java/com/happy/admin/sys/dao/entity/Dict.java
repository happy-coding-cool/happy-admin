package com.happy.admin.sys.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@TableName("h_dict")
public class Dict extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 字典名称
     */
    @TableField("name")
    private String name;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

}
