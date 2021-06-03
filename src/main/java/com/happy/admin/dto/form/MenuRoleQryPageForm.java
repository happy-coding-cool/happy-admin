package com.happy.admin.dto.form;

import cool.happycoding.code.base.pojo.PageForm;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 菜单角色关系 分页查询
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@ApiModel(value="MenuRoleQryPageForm对象", description="菜单角色关系分页查询")
public class MenuRoleQryPageForm extends PageForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "菜单ID")
    private String menuId;

    @ApiModelProperty(value = "角色ID")
    private String roleId;

}