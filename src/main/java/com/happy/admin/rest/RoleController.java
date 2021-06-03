package com.happy.admin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happy.admin.dto.form.RoleAddForm;
import com.happy.admin.dto.form.RoleQryForm;
import com.happy.admin.dto.form.RoleQryPageForm;
import com.happy.admin.dto.form.RoleUpdateForm;
import com.happy.admin.dto.RoleDto;
import com.happy.admin.service.IRoleService;
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
 * 角色 前端控制器
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */

@Validated
@RestController
@Api(tags="角色")
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {

    /**
     * 角色 服务类
     */
    private final IRoleService roleServiceImpl;

    @ApiOperation(value = "新增角色", notes = "新增角色")
    @PostMapping
    public BaseResult<RoleDto> add(@RequestBody RoleAddForm roleAddForm) {
       return BaseResult.success(roleServiceImpl.save(roleAddForm));
    }

    @ApiOperation(value = "删除角色", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(roleServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改角色", notes = "修改指定角色信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody RoleUpdateForm roleUpdateForm) {
       roleUpdateForm.setId(id);
       return BaseResult.success(roleServiceImpl.update(roleUpdateForm));
    }

    @ApiOperation(value = "获取角色", notes = "获取指定角色信息")
    @GetMapping(value = "/{id}")
    public BaseResult<RoleDto> get(@PathVariable String id) {
       return BaseResult.success(roleServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索角色", notes = "根据条件查询角色信息")
    @PostMapping(value = "/list")
    public ListResult<RoleDto> list(@RequestBody RoleQryForm roleQryForm) {
        return ListResult.success(roleServiceImpl.list(roleQryForm));
    }

    @ApiOperation(value = "分页搜索角色", notes = "根据条件分页查询角色信息")
    @PostMapping(value = "/page")
    public PageResult<RoleDto> page(@RequestBody RoleQryPageForm roleQryPageForm) {
        IPage<RoleDto> page = roleServiceImpl.page(roleQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
