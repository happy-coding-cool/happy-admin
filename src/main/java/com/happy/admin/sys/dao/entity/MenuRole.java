package com.happy.admin.sys.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 菜单角色关系
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@TableName("h_menu_role")
public class MenuRole extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 菜单ID
     */
    @TableField("menu_id")
    private String menuId;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private String roleId;

}
