package com.happy.admin.dto.form;

import cool.happycoding.code.mybatis.base.BaseForm;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 岗位 查询
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@ApiModel(value="PostQryForm对象", description="岗位查询")
public class PostQryForm extends BaseForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "岗位编码")
    private String poshCode;

    @ApiModelProperty(value = "岗位名称")
    private String poshName;

    @ApiModelProperty(value = "岗位状态")
    private Boolean poshSta;

    @ApiModelProperty(value = "排序")
    private Integer poshSort;

}