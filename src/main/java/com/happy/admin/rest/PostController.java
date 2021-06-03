package com.happy.admin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happy.admin.dto.form.PostAddForm;
import com.happy.admin.dto.form.PostQryForm;
import com.happy.admin.dto.form.PostQryPageForm;
import com.happy.admin.dto.form.PostUpdateForm;
import com.happy.admin.dto.PostDto;
import com.happy.admin.service.IPostService;
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
 * 岗位 前端控制器
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */

@Validated
@RestController
@Api(tags="岗位")
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    /**
     * 岗位 服务类
     */
    private final IPostService postServiceImpl;

    @ApiOperation(value = "新增岗位", notes = "新增岗位")
    @PostMapping
    public BaseResult<PostDto> add(@RequestBody PostAddForm postAddForm) {
       return BaseResult.success(postServiceImpl.save(postAddForm));
    }

    @ApiOperation(value = "删除岗位", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(postServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改岗位", notes = "修改指定岗位信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody PostUpdateForm postUpdateForm) {
       postUpdateForm.setId(id);
       return BaseResult.success(postServiceImpl.update(postUpdateForm));
    }

    @ApiOperation(value = "获取岗位", notes = "获取指定岗位信息")
    @GetMapping(value = "/{id}")
    public BaseResult<PostDto> get(@PathVariable String id) {
       return BaseResult.success(postServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索岗位", notes = "根据条件查询岗位信息")
    @PostMapping(value = "/list")
    public ListResult<PostDto> list(@RequestBody PostQryForm postQryForm) {
        return ListResult.success(postServiceImpl.list(postQryForm));
    }

    @ApiOperation(value = "分页搜索岗位", notes = "根据条件分页查询岗位信息")
    @PostMapping(value = "/page")
    public PageResult<PostDto> page(@RequestBody PostQryPageForm postQryPageForm) {
        IPage<PostDto> page = postServiceImpl.page(postQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
