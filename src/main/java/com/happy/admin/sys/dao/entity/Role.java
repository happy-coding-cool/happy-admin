package com.happy.admin.sys.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@TableName("h_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 角色编码
     */
    @TableField("role_code")
    private String roleCode;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 角色级别
     */
    @TableField("role_level")
    private Integer roleLevel;

    /**
     * 描述
     */
    @TableField("role_desc")
    private String roleDesc;

    /**
     * 数据权限
     */
    @TableField("data_scope")
    private String dataScope;

}
