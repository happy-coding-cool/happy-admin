-- 用户
drop table if exists h_user;
create table h_user (
    `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
    `account` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '用户账号',
    `password` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码',
    `user_name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名称',
    `nick_name` varchar(32) COLLATE utf8mb4_bin default NULL COMMENT '昵称',
    `user_icon` varchar(128) COLLATE utf8mb4_bin default NULL COMMENT '头像',
    `gender` varchar(2) COLLATE utf8mb4_bin default NULL COMMENT '性别',
    `mobile` varchar(15) COLLATE utf8mb4_bin NOT NULL COMMENT '手机号',
    `mail` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '邮箱',
    `org_id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '组织ID',
    `user_type` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户类型：管理员/普通用户',
    `user_sta` char(1) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户状态',
    `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
    `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
    `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
    `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
    `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_h_user_account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户';


-- 角色
drop table if exists h_role;
create table h_role (
    `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
    `role_code` varchar(32) DEFAULT NULL COMMENT '角色编码',
    `role_name` varchar(32) NOT NULL COMMENT '角色名称',
    `role_level` int(32) DEFAULT NULL COMMENT '角色级别',
    `role_desc` varchar(32) DEFAULT NULL COMMENT '描述',
    `data_scope` varchar(32) DEFAULT NULL COMMENT '数据权限',
    `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
    `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
    `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
    `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
    `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_role_name` (`role_name`),
    KEY `role_name_index` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='角色';

-- 组织
drop table if exists h_org;
create table h_org (
   `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
   `parent_id` varchar(32) COLLATE utf8mb4_bin NULL COMMENT '父级ID',
   `sub_count` int(5) DEFAULT 0 COMMENT '子部门数目',
   `org_code` varchar(32) COLLATE utf8mb4_bin NULL COMMENT '组织编码',
   `org_name` varchar(32) COLLATE utf8mb4_bin NULL COMMENT '组织名称',
   `org_manager` varchar(255) COLLATE utf8mb4_bin NULL COMMENT '组织负责人',
   `org_sort` int(5) DEFAULT 999 COMMENT '排序',
   `org_sta` bit(1)  NULL COMMENT '状态',
   `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
   `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
   `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
   `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
   `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
   PRIMARY KEY (`id`),
   UNIQUE KEY `unique_h_org_name` (`org_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='组织';

-- 岗位
drop table if exists h_post;
create table h_post (
    `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
    `posh_code` varchar(32) DEFAULT NULL COMMENT '岗位编码',
    `posh_name` varchar(32) NOT NULL COMMENT '岗位名称',
    `posh_sta` bit(1) NOT NULL COMMENT '岗位状态',
    `posh_sort` int(5) DEFAULT NULL COMMENT '排序',
    `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
    `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
    `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
    `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
    `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_h_posh_name` (`posh_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='岗位';

-- 菜单
drop table if exists h_menu;
create table h_menu (
    `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
    `parent_id` varchar(32) DEFAULT NULL COMMENT '上级菜单ID',
    `sub_count` int(5) DEFAULT 0 COMMENT '子菜单数目',
    `menu_type` int(11) DEFAULT NULL COMMENT '菜单类型',
    `menu_title` varchar(32) DEFAULT NULL COMMENT '菜单标题',
    `menu_sort` int(5) DEFAULT NULL COMMENT '排序',
    `menu_icon` varchar(64) DEFAULT NULL COMMENT '图标',
    `menu_path` varchar(128) DEFAULT NULL COMMENT '链接地址',
    `hidden` bit(1) DEFAULT b'0' COMMENT '隐藏',
    `integration_mode` varchar(32) DEFAULT '1' COMMENT '集成方式：1：内链(新的tab)、2：外链(打开新窗口)、3：iframe(iframe 嵌入)、4：微前端架构' ,
    `menu_permission` varchar(64) DEFAULT NULL COMMENT '权限',
    `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
    `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
    `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
    `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
    `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='菜单';


-- 用户岗位关系
drop table if exists h_user_post;
create table h_user_post (
     `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
     `user_id` varchar(32) NOT NULL COMMENT '用户ID',
     `posh_id` varchar(32) NOT NULL COMMENT '岗位ID',
     `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
     `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
     `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
     `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
     `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户岗位关系';


-- 用户角色关系
drop table if exists h_user_role;
create table h_user_role (
     `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
     `user_id` varchar(32) NOT NULL COMMENT '用户ID',
     `role_id` varchar(32) NOT NULL COMMENT '角色ID',
     `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
     `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
     `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
     `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
     `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='用户角色关系';


-- 菜单角色关系
drop table if exists h_menu_role;
create table h_menu_role (
    `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
    `menu_id` varchar(32) NOT NULL COMMENT '菜单ID',
    `role_id` varchar(32) NOT NULL COMMENT '角色ID',
    `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
    `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
    `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
    `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
    `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='菜单角色关系';


-- 组织角色关系
drop table if exists h_org_role;
create table h_org_role (
    `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
    `org_id` varchar(32) NOT NULL COMMENT '组织ID',
    `role_id` varchar(32) NOT NULL COMMENT '角色ID',
    `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
    `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
    `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
    `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
    `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='组织角色关系';


-- 字典
DROP TABLE IF EXISTS `h_dict`;
CREATE TABLE `h_dict` (
    `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
    `name` varchar(32) NOT NULL COMMENT '字典名称',
    `description` varchar(32) DEFAULT NULL COMMENT '描述',
    `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
    `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
    `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
    `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
    `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE `unique_h_dict_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='数据字典';

-- 字典详情
DROP TABLE IF EXISTS `h_dich_detail`;
CREATE TABLE `h_dict_detail` (
     `id` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
     `dict_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典id',
     `label` varchar(32) NOT NULL COMMENT '字典标签',
     `value` varchar(32) NOT NULL COMMENT '字典值',
     `dict_sort` int(5) DEFAULT NULL COMMENT '排序',
     `created_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人姓名',
     `created_by_id` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '创建人ID',
     `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `updated_by` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '-1' COMMENT '更新人姓名',
     `updated_by_id` varchar(50) NOT NULL DEFAULT '-1' COMMENT '更新人ID',
     `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
     PRIMARY KEY (`id`),
     KEY `idx_h_dict_id` (`dict_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='数据字典详情';
