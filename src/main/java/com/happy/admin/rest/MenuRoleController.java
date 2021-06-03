package com.happy.admin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happy.admin.dto.form.MenuRoleAddForm;
import com.happy.admin.dto.form.MenuRoleQryForm;
import com.happy.admin.dto.form.MenuRoleQryPageForm;
import com.happy.admin.dto.form.MenuRoleUpdateForm;
import com.happy.admin.dto.MenuRoleDto;
import com.happy.admin.service.IMenuRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.base.result.ListResult;
import cool.happycoding.code.base.result.PageResult;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 菜单角色关系 前端控制器
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */

@Validated
@RestController
@Api(tags="菜单角色关系")
@RequiredArgsConstructor
@RequestMapping("/menu-role")
public class MenuRoleController {

    /**
     * 菜单角色关系 服务类
     */
    private final IMenuRoleService menuRoleServiceImpl;

    @ApiOperation(value = "新增菜单角色关系", notes = "新增菜单角色关系")
    @PostMapping
    public BaseResult<MenuRoleDto> add(@RequestBody MenuRoleAddForm menuRoleAddForm) {
       return BaseResult.success(menuRoleServiceImpl.save(menuRoleAddForm));
    }

    @ApiOperation(value = "删除菜单角色关系", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(menuRoleServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改菜单角色关系", notes = "修改指定菜单角色关系信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody MenuRoleUpdateForm menuRoleUpdateForm) {
       menuRoleUpdateForm.setId(id);
       return BaseResult.success(menuRoleServiceImpl.update(menuRoleUpdateForm));
    }

    @ApiOperation(value = "获取菜单角色关系", notes = "获取指定菜单角色关系信息")
    @GetMapping(value = "/{id}")
    public BaseResult<MenuRoleDto> get(@PathVariable String id) {
       return BaseResult.success(menuRoleServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索菜单角色关系", notes = "根据条件查询菜单角色关系信息")
    @PostMapping(value = "/list")
    public ListResult<MenuRoleDto> list(@RequestBody MenuRoleQryForm menuRoleQryForm) {
        return ListResult.success(menuRoleServiceImpl.list(menuRoleQryForm));
    }

    @ApiOperation(value = "分页搜索菜单角色关系", notes = "根据条件分页查询菜单角色关系信息")
    @PostMapping(value = "/page")
    public PageResult<MenuRoleDto> page(@RequestBody MenuRoleQryPageForm menuRoleQryPageForm) {
        IPage<MenuRoleDto> page = menuRoleServiceImpl.page(menuRoleQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
