package com.happy.admin.sys.service;

import com.happy.admin.sys.dao.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.admin.sys.dto.form.MenuAddForm;
import com.happy.admin.sys.dto.form.MenuQryForm;
import com.happy.admin.sys.dto.form.MenuQryPageForm;
import com.happy.admin.sys.dto.form.MenuUpdateForm;
import com.happy.admin.sys.dto.MenuDto;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 获取菜单
     *
     * @param id 菜单id
     * @return MenuDto
     */
    MenuDto get(String id);

    /**
     * 获取菜单
     *
     * @param menuAddForm
     * @return MenuDto
     */
    MenuDto save(MenuAddForm menuAddForm);

    /**
     * 更新菜单信息
     *
     * @param menuUpdateForm
     * @return
     */
    boolean update(MenuUpdateForm menuUpdateForm);

    /**
     * 根据id删除菜单
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询菜单
     *
     * @param menuQryForm
     * @return
     */
    List<MenuDto> list(MenuQryForm menuQryForm);

    /**
     * 查询菜单
     * @param menuQryPageForm
     * @return
     */
    IPage<MenuDto> page(MenuQryPageForm menuQryPageForm);
}
