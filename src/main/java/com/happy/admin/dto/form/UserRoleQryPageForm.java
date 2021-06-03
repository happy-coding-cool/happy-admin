package com.happy.admin.dto.form;

import cool.happycoding.code.base.pojo.PageForm;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户角色关系 分页查询
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@ApiModel(value="UserRoleQryPageForm对象", description="用户角色关系分页查询")
public class UserRoleQryPageForm extends PageForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "角色ID")
    private String roleId;

}