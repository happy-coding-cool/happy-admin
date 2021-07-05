package com.happy.admin.sys.rest;

import com.happy.admin.sys.dto.form.UserRoleAddForm;
import com.happy.admin.sys.dto.form.UserRoleUpdateForm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happy.admin.sys.dto.form.UserRoleQryForm;
import com.happy.admin.sys.dto.form.UserRoleQryPageForm;
import com.happy.admin.sys.dto.UserRoleDto;
import com.happy.admin.sys.service.IUserRoleService;
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
 * 用户角色关系 前端控制器
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */

@Validated
@RestController
@Api(tags="用户角色关系")
@RequiredArgsConstructor
@RequestMapping("/user-role")
public class UserRoleController {

    /**
     * 用户角色关系 服务类
     */
    private final IUserRoleService userRoleServiceImpl;

    @ApiOperation(value = "新增用户角色关系", notes = "新增用户角色关系")
    @PostMapping
    public BaseResult<UserRoleDto> add(@RequestBody UserRoleAddForm userRoleAddForm) {
       return BaseResult.success(userRoleServiceImpl.save(userRoleAddForm));
    }

    @ApiOperation(value = "删除用户角色关系", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(userRoleServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改用户角色关系", notes = "修改指定用户角色关系信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody UserRoleUpdateForm userRoleUpdateForm) {
       userRoleUpdateForm.setId(id);
       return BaseResult.success(userRoleServiceImpl.update(userRoleUpdateForm));
    }

    @ApiOperation(value = "获取用户角色关系", notes = "获取指定用户角色关系信息")
    @GetMapping(value = "/{id}")
    public BaseResult<UserRoleDto> get(@PathVariable String id) {
       return BaseResult.success(userRoleServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索用户角色关系", notes = "根据条件查询用户角色关系信息")
    @PostMapping(value = "/list")
    public ListResult<UserRoleDto> list(@RequestBody UserRoleQryForm userRoleQryForm) {
        return ListResult.success(userRoleServiceImpl.list(userRoleQryForm));
    }

    @ApiOperation(value = "分页搜索用户角色关系", notes = "根据条件分页查询用户角色关系信息")
    @PostMapping(value = "/page")
    public PageResult<UserRoleDto> page(@RequestBody UserRoleQryPageForm userRoleQryPageForm) {
        IPage<UserRoleDto> page = userRoleServiceImpl.page(userRoleQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
