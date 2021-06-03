package com.happy.admin.dto;

import cool.happycoding.code.mybatis.base.BaseDTO;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 菜单 前端展示对象
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@ApiModel(value="MenuDto对象", description="菜单")
public class MenuDto extends BaseDTO {

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

    @ApiModelProperty(value = "创建人姓名")
    private String createdBy;

    @ApiModelProperty(value = "创建人ID")
    private String createdById;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新人姓名")
    private String updatedBy;

    @ApiModelProperty(value = "更新人ID")
    private String updatedById;

    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;

}
