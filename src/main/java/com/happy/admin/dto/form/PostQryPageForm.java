package com.happy.admin.dto.form;

import cool.happycoding.code.base.pojo.PageForm;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 岗位 分页查询
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@ApiModel(value="PostQryPageForm对象", description="岗位分页查询")
public class PostQryPageForm extends PageForm {

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