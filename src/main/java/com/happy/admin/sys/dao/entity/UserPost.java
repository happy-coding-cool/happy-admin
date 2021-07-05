package com.happy.admin.sys.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 用户岗位关系
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@TableName("h_user_post")
public class UserPost extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 岗位ID
     */
    @TableField("posh_id")
    private String poshId;

}
