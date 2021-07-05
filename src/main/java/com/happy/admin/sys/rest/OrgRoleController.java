package com.happy.admin.sys.rest;

import com.happy.admin.sys.dto.form.OrgRoleAddForm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happy.admin.sys.dto.form.OrgRoleQryForm;
import com.happy.admin.sys.dto.form.OrgRoleQryPageForm;
import com.happy.admin.sys.dto.form.OrgRoleUpdateForm;
import com.happy.admin.sys.dto.OrgRoleDto;
import com.happy.admin.sys.service.IOrgRoleService;
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
 * 组织角色关系 前端控制器
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */

@Validated
@RestController
@Api(tags="组织角色关系")
@RequiredArgsConstructor
@RequestMapping("/org-role")
public class OrgRoleController {

    /**
     * 组织角色关系 服务类
     */
    private final IOrgRoleService orgRoleServiceImpl;

    @ApiOperation(value = "新增组织角色关系", notes = "新增组织角色关系")
    @PostMapping
    public BaseResult<OrgRoleDto> add(@RequestBody OrgRoleAddForm orgRoleAddForm) {
       return BaseResult.success(orgRoleServiceImpl.save(orgRoleAddForm));
    }

    @ApiOperation(value = "删除组织角色关系", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(orgRoleServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改组织角色关系", notes = "修改指定组织角色关系信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody OrgRoleUpdateForm orgRoleUpdateForm) {
       orgRoleUpdateForm.setId(id);
       return BaseResult.success(orgRoleServiceImpl.update(orgRoleUpdateForm));
    }

    @ApiOperation(value = "获取组织角色关系", notes = "获取指定组织角色关系信息")
    @GetMapping(value = "/{id}")
    public BaseResult<OrgRoleDto> get(@PathVariable String id) {
       return BaseResult.success(orgRoleServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索组织角色关系", notes = "根据条件查询组织角色关系信息")
    @PostMapping(value = "/list")
    public ListResult<OrgRoleDto> list(@RequestBody OrgRoleQryForm orgRoleQryForm) {
        return ListResult.success(orgRoleServiceImpl.list(orgRoleQryForm));
    }

    @ApiOperation(value = "分页搜索组织角色关系", notes = "根据条件分页查询组织角色关系信息")
    @PostMapping(value = "/page")
    public PageResult<OrgRoleDto> page(@RequestBody OrgRoleQryPageForm orgRoleQryPageForm) {
        IPage<OrgRoleDto> page = orgRoleServiceImpl.page(orgRoleQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
