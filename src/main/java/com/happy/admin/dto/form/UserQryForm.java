package com.happy.admin.dto.form;

import cool.happycoding.code.mybatis.base.BaseForm;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户 查询
 * </p>
 *
 * @author happycoding
 * @since 2021-05-10
 */
@Data
@ApiModel(value="UserQryForm对象", description="用户查询")
public class UserQryForm extends BaseForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户账号")
    private String account;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "组织ID")
    private String orgId;

    @ApiModelProperty(value = "用户状态")
    private String userSta;

}