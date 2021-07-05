package com.happy.admin.sys.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 组织
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@TableName("h_org")
public class Org extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 父级ID
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 子部门数目
     */
    @TableField("sub_count")
    private Integer subCount;

    /**
     * 组织编码
     */
    @TableField("org_code")
    private String orgCode;

    /**
     * 组织名称
     */
    @TableField("org_name")
    private String orgName;

    /**
     * 组织负责人
     */
    @TableField("org_manager")
    private String orgManager;

    /**
     * 排序
     */
    @TableField("org_sort")
    private Integer orgSort;

    /**
     * 状态
     */
    @TableField("org_sta")
    private Boolean orgSta;

}
