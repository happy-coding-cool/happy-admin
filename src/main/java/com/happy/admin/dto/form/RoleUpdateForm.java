package com.happy.admin.dto.form;

import cool.happycoding.code.mybatis.base.BaseForm;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 角色 更新
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@ApiModel(value="RoleUpdateForm对象", description="角色更新")
public class RoleUpdateForm extends BaseForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色级别")
    private Integer roleLevel;

    @ApiModelProperty(value = "描述")
    private String roleDesc;

    @ApiModelProperty(value = "数据权限")
    private String dataScope;

}