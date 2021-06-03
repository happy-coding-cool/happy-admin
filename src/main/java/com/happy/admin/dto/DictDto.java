package com.happy.admin.dto;

import cool.happycoding.code.mybatis.base.BaseDTO;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 数据字典 前端展示对象
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@ApiModel(value="DictDto对象", description="数据字典")
public class DictDto extends BaseDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

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
