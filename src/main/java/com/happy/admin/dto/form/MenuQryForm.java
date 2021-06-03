package com.happy.admin.dto.form;

import cool.happycoding.code.mybatis.base.BaseForm;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 菜单 查询
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@ApiModel(value="MenuQryForm对象", description="菜单查询")
public class MenuQryForm extends BaseForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "上级菜单ID")
    private String parentId;

    @ApiModelProperty(value = "子菜单数目")
    private Integer subCount;

    @ApiModelProperty(value = "菜单类型")
    private Integer menuType;

    @ApiModelProperty(value = "菜单标题")
    private String menuTitle;

    @ApiModelProperty(value = "排序")
    private Integer menuSort;

    @ApiModelProperty(value = "图标")
    private String menuIcon;

    @ApiModelProperty(value = "链接地址")
    private String menuPath;

    @ApiModelProperty(value = "隐藏")
    private Boolean hidden;

    @ApiModelProperty(value = "集成方式：1：内链(新的tab)、2：外链(打开新窗口)、3：iframe(iframe 嵌入)、4：微前端架构")
    private String integrationMode;

    @ApiModelProperty(value = "权限")
    private String menuPermission;

}