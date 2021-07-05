package com.happy.admin.sys.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 岗位
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@TableName("h_post")
public class Post extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 岗位编码
     */
    @TableField("posh_code")
    private String poshCode;

    /**
     * 岗位名称
     */
    @TableField("posh_name")
    private String poshName;

    /**
     * 岗位状态
     */
    @TableField("posh_sta")
    private Boolean poshSta;

    /**
     * 排序
     */
    @TableField("posh_sort")
    private Integer poshSort;

}
