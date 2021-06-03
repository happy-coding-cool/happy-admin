package com.happy.admin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happy.admin.dto.form.OrgAddForm;
import com.happy.admin.dto.form.OrgQryForm;
import com.happy.admin.dto.form.OrgQryPageForm;
import com.happy.admin.dto.form.OrgUpdateForm;
import com.happy.admin.dto.OrgDto;
import com.happy.admin.service.IOrgService;
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
 * 组织 前端控制器
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */

@Validated
@RestController
@Api(tags="组织")
@RequiredArgsConstructor
@RequestMapping("/org")
public class OrgController {

    /**
     * 组织 服务类
     */
    private final IOrgService orgServiceImpl;

    @ApiOperation(value = "新增组织", notes = "新增组织")
    @PostMapping
    public BaseResult<OrgDto> add(@RequestBody OrgAddForm orgAddForm) {
       return BaseResult.success(orgServiceImpl.save(orgAddForm));
    }

    @ApiOperation(value = "删除组织", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(orgServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改组织", notes = "修改指定组织信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody OrgUpdateForm orgUpdateForm) {
       orgUpdateForm.setId(id);
       return BaseResult.success(orgServiceImpl.update(orgUpdateForm));
    }

    @ApiOperation(value = "获取组织", notes = "获取指定组织信息")
    @GetMapping(value = "/{id}")
    public BaseResult<OrgDto> get(@PathVariable String id) {
       return BaseResult.success(orgServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索组织", notes = "根据条件查询组织信息")
    @PostMapping(value = "/list")
    public ListResult<OrgDto> list(@RequestBody OrgQryForm orgQryForm) {
        return ListResult.success(orgServiceImpl.list(orgQryForm));
    }

    @ApiOperation(value = "分页搜索组织", notes = "根据条件分页查询组织信息")
    @PostMapping(value = "/page")
    public PageResult<OrgDto> page(@RequestBody OrgQryPageForm orgQryPageForm) {
        IPage<OrgDto> page = orgServiceImpl.page(orgQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
