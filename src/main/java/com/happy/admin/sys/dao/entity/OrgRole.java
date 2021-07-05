package com.happy.admin.sys.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 组织角色关系
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@TableName("h_org_role")
public class OrgRole extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 组织ID
     */
    @TableField("org_id")
    private String orgId;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private String roleId;

}
