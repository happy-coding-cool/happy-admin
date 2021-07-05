package com.happy.admin.sys.service;

import com.happy.admin.sys.dao.entity.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.admin.sys.dto.form.MenuRoleAddForm;
import com.happy.admin.sys.dto.form.MenuRoleQryForm;
import com.happy.admin.sys.dto.form.MenuRoleQryPageForm;
import com.happy.admin.sys.dto.form.MenuRoleUpdateForm;
import com.happy.admin.sys.dto.MenuRoleDto;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 菜单角色关系 服务类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 获取菜单角色关系
     *
     * @param id 菜单角色关系id
     * @return MenuRoleDto
     */
    MenuRoleDto get(String id);

    /**
     * 获取菜单角色关系
     *
     * @param menuRoleAddForm
     * @return MenuRoleDto
     */
    MenuRoleDto save(MenuRoleAddForm menuRoleAddForm);

    /**
     * 更新菜单角色关系信息
     *
     * @param menuRoleUpdateForm
     * @return
     */
    boolean update(MenuRoleUpdateForm menuRoleUpdateForm);

    /**
     * 根据id删除菜单角色关系
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询菜单角色关系
     *
     * @param menuRoleQryForm
     * @return
     */
    List<MenuRoleDto> list(MenuRoleQryForm menuRoleQryForm);

    /**
     * 查询菜单角色关系
     * @param menuRoleQryPageForm
     * @return
     */
    IPage<MenuRoleDto> page(MenuRoleQryPageForm menuRoleQryPageForm);
}
