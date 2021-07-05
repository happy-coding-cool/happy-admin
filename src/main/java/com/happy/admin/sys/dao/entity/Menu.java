package com.happy.admin.sys.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Data
@TableName("h_menu")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 上级菜单ID
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 子菜单数目
     */
    @TableField("sub_count")
    private Integer subCount;

    /**
     * 菜单类型
     */
    @TableField("menu_type")
    private Integer menuType;

    /**
     * 菜单标题
     */
    @TableField("menu_title")
    private String menuTitle;

    /**
     * 排序
     */
    @TableField("menu_sort")
    private Integer menuSort;

    /**
     * 图标
     */
    @TableField("menu_icon")
    private String menuIcon;

    /**
     * 链接地址
     */
    @TableField("menu_path")
    private String menuPath;

    /**
     * 隐藏
     */
    @TableField("hidden")
    private Boolean hidden;

    /**
     * 集成方式：1：内链(新的tab)、2：外链(打开新窗口)、3：iframe(iframe 嵌入)、4：微前端架构
     */
    @TableField("integration_mode")
    private String integrationMode;

    /**
     * 权限
     */
    @TableField("menu_permission")
    private String menuPermission;

}
