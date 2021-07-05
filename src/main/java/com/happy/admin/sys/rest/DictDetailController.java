package com.happy.admin.sys.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happy.admin.sys.dto.form.DictDetailAddForm;
import com.happy.admin.sys.dto.form.DictDetailQryForm;
import com.happy.admin.sys.dto.form.DictDetailQryPageForm;
import com.happy.admin.sys.dto.form.DictDetailUpdateForm;
import com.happy.admin.sys.dto.DictDetailDto;
import com.happy.admin.sys.service.IDictDetailService;
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
 * 数据字典详情 前端控制器
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */

@Validated
@RestController
@Api(tags="数据字典详情")
@RequiredArgsConstructor
@RequestMapping("/dict-detail")
public class DictDetailController {

    /**
     * 数据字典详情 服务类
     */
    private final IDictDetailService dictDetailServiceImpl;

    @ApiOperation(value = "新增数据字典详情", notes = "新增数据字典详情")
    @PostMapping
    public BaseResult<DictDetailDto> add(@RequestBody DictDetailAddForm dictDetailAddForm) {
       return BaseResult.success(dictDetailServiceImpl.save(dictDetailAddForm));
    }

    @ApiOperation(value = "删除数据字典详情", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(dictDetailServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改数据字典详情", notes = "修改指定数据字典详情信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody DictDetailUpdateForm dictDetailUpdateForm) {
       dictDetailUpdateForm.setId(id);
       return BaseResult.success(dictDetailServiceImpl.update(dictDetailUpdateForm));
    }

    @ApiOperation(value = "获取数据字典详情", notes = "获取指定数据字典详情信息")
    @GetMapping(value = "/{id}")
    public BaseResult<DictDetailDto> get(@PathVariable String id) {
       return BaseResult.success(dictDetailServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索数据字典详情", notes = "根据条件查询数据字典详情信息")
    @PostMapping(value = "/list")
    public ListResult<DictDetailDto> list(@RequestBody DictDetailQryForm dictDetailQryForm) {
        return ListResult.success(dictDetailServiceImpl.list(dictDetailQryForm));
    }

    @ApiOperation(value = "分页搜索数据字典详情", notes = "根据条件分页查询数据字典详情信息")
    @PostMapping(value = "/page")
    public PageResult<DictDetailDto> page(@RequestBody DictDetailQryPageForm dictDetailQryPageForm) {
        IPage<DictDetailDto> page = dictDetailServiceImpl.page(dictDetailQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
