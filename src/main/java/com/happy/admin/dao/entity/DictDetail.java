package com.happy.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 数据字典详情
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@TableName("h_dict_detail")
public class DictDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 字典id
     */
    @TableField("dict_id")
    private String dictId;

    /**
     * 字典标签
     */
    @TableField("label")
    private String label;

    /**
     * 字典值
     */
    @TableField("value")
    private String value;

    /**
     * 排序
     */
    @TableField("dict_sort")
    private Integer dictSort;

}
