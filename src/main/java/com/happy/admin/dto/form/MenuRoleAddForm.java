package com.happy.admin.dto.form;

import cool.happycoding.code.mybatis.base.BaseForm;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 菜单角色关系 新增
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@ApiModel(value="MenuRoleAddForm对象", description="菜单角色关系新增")
public class MenuRoleAddForm extends BaseForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单ID")
    private String menuId;

    @ApiModelProperty(value = "角色ID")
    private String roleId;

}