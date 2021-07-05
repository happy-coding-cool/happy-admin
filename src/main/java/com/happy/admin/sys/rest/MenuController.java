package com.happy.admin.sys.rest;

import com.happy.admin.sys.dto.form.MenuAddForm;
import com.happy.admin.sys.dto.form.MenuQryForm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happy.admin.sys.dto.form.MenuQryPageForm;
import com.happy.admin.sys.dto.form.MenuUpdateForm;
import com.happy.admin.sys.dto.MenuDto;
import com.happy.admin.sys.service.IMenuService;
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
 * 菜单 前端控制器
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */

@Validated
@RestController
@Api(tags="菜单")
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    /**
     * 菜单 服务类
     */
    private final IMenuService menuServiceImpl;

    @ApiOperation(value = "新增菜单", notes = "新增菜单")
    @PostMapping
    public BaseResult<MenuDto> add(@RequestBody MenuAddForm menuAddForm) {
       return BaseResult.success(menuServiceImpl.save(menuAddForm));
    }

    @ApiOperation(value = "删除菜单", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(menuServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改菜单", notes = "修改指定菜单信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody MenuUpdateForm menuUpdateForm) {
       menuUpdateForm.setId(id);
       return BaseResult.success(menuServiceImpl.update(menuUpdateForm));
    }

    @ApiOperation(value = "获取菜单", notes = "获取指定菜单信息")
    @GetMapping(value = "/{id}")
    public BaseResult<MenuDto> get(@PathVariable String id) {
       return BaseResult.success(menuServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索菜单", notes = "根据条件查询菜单信息")
    @PostMapping(value = "/list")
    public ListResult<MenuDto> list(@RequestBody MenuQryForm menuQryForm) {
        return ListResult.success(menuServiceImpl.list(menuQryForm));
    }

    @ApiOperation(value = "分页搜索菜单", notes = "根据条件分页查询菜单信息")
    @PostMapping(value = "/page")
    public PageResult<MenuDto> page(@RequestBody MenuQryPageForm menuQryPageForm) {
        IPage<MenuDto> page = menuServiceImpl.page(menuQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
