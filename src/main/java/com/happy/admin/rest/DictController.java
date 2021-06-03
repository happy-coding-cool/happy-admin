package com.happy.admin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happy.admin.dto.form.DictAddForm;
import com.happy.admin.dto.form.DictQryForm;
import com.happy.admin.dto.form.DictQryPageForm;
import com.happy.admin.dto.form.DictUpdateForm;
import com.happy.admin.dto.DictDto;
import com.happy.admin.service.IDictService;
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
 * 数据字典 前端控制器
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */

@Validated
@RestController
@Api(tags="数据字典")
@RequiredArgsConstructor
@RequestMapping("/dict")
public class DictController {

    /**
     * 数据字典 服务类
     */
    private final IDictService dictServiceImpl;

    @ApiOperation(value = "新增数据字典", notes = "新增数据字典")
    @PostMapping
    public BaseResult<DictDto> add(@RequestBody DictAddForm dictAddForm) {
       return BaseResult.success(dictServiceImpl.save(dictAddForm));
    }

    @ApiOperation(value = "删除数据字典", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(dictServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改数据字典", notes = "修改指定数据字典信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody DictUpdateForm dictUpdateForm) {
       dictUpdateForm.setId(id);
       return BaseResult.success(dictServiceImpl.update(dictUpdateForm));
    }

    @ApiOperation(value = "获取数据字典", notes = "获取指定数据字典信息")
    @GetMapping(value = "/{id}")
    public BaseResult<DictDto> get(@PathVariable String id) {
       return BaseResult.success(dictServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索数据字典", notes = "根据条件查询数据字典信息")
    @PostMapping(value = "/list")
    public ListResult<DictDto> list(@RequestBody DictQryForm dictQryForm) {
        return ListResult.success(dictServiceImpl.list(dictQryForm));
    }

    @ApiOperation(value = "分页搜索数据字典", notes = "根据条件分页查询数据字典信息")
    @PostMapping(value = "/page")
    public PageResult<DictDto> page(@RequestBody DictQryPageForm dictQryPageForm) {
        IPage<DictDto> page = dictServiceImpl.page(dictQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
