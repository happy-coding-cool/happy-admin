package com.happy.admin.service;

import com.happy.admin.dao.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.admin.dto.form.RoleAddForm;
import com.happy.admin.dto.form.RoleQryForm;
import com.happy.admin.dto.form.RoleQryPageForm;
import com.happy.admin.dto.form.RoleUpdateForm;
import com.happy.admin.dto.RoleDto;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
public interface IRoleService extends IService<Role> {

    /**
     * 获取角色
     *
     * @param id 角色id
     * @return RoleDto
     */
    RoleDto get(String id);

    /**
     * 获取角色
     *
     * @param roleAddForm
     * @return RoleDto
     */
    RoleDto save(RoleAddForm roleAddForm);

    /**
     * 更新角色信息
     *
     * @param roleUpdateForm
     * @return
     */
    boolean update(RoleUpdateForm roleUpdateForm);

    /**
     * 根据id删除角色
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询角色
     *
     * @param roleQryForm
     * @return
     */
    List<RoleDto> list(RoleQryForm roleQryForm);

    /**
     * 查询角色
     * @param roleQryPageForm
     * @return
     */
    IPage<RoleDto> page(RoleQryPageForm roleQryPageForm);
}
