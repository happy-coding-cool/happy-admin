package com.happy.admin.dto.form;

import cool.happycoding.code.mybatis.base.BaseForm;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 数据字典 新增
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@ApiModel(value="DictAddForm对象", description="数据字典新增")
public class DictAddForm extends BaseForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

}