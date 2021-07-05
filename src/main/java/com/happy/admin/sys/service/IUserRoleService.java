package com.happy.admin.sys.service;

import com.happy.admin.sys.dao.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.admin.sys.dto.form.UserRoleAddForm;
import com.happy.admin.sys.dto.form.UserRoleQryForm;
import com.happy.admin.sys.dto.form.UserRoleQryPageForm;
import com.happy.admin.sys.dto.form.UserRoleUpdateForm;
import com.happy.admin.sys.dto.UserRoleDto;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 用户角色关系 服务类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
public interface IUserRoleService extends IService<UserRole> {

    /**
     * 获取用户角色关系
     *
     * @param id 用户角色关系id
     * @return UserRoleDto
     */
    UserRoleDto get(String id);

    /**
     * 获取用户角色关系
     *
     * @param userRoleAddForm
     * @return UserRoleDto
     */
    UserRoleDto save(UserRoleAddForm userRoleAddForm);

    /**
     * 更新用户角色关系信息
     *
     * @param userRoleUpdateForm
     * @return
     */
    boolean update(UserRoleUpdateForm userRoleUpdateForm);

    /**
     * 根据id删除用户角色关系
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询用户角色关系
     *
     * @param userRoleQryForm
     * @return
     */
    List<UserRoleDto> list(UserRoleQryForm userRoleQryForm);

    /**
     * 查询用户角色关系
     * @param userRoleQryPageForm
     * @return
     */
    IPage<UserRoleDto> page(UserRoleQryPageForm userRoleQryPageForm);
}
