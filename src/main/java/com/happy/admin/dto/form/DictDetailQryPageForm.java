package com.happy.admin.dto.form;

import cool.happycoding.code.base.pojo.PageForm;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 数据字典详情 分页查询
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@ApiModel(value="DictDetailQryPageForm对象", description="数据字典详情分页查询")
public class DictDetailQryPageForm extends PageForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "字典id")
    private String dictId;

    @ApiModelProperty(value = "字典标签")
    private String label;

    @ApiModelProperty(value = "字典值")
    private String value;

    @ApiModelProperty(value = "排序")
    private Integer dictSort;

}