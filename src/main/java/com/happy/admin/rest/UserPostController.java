package com.happy.admin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happy.admin.dto.form.UserPostAddForm;
import com.happy.admin.dto.form.UserPostQryForm;
import com.happy.admin.dto.form.UserPostQryPageForm;
import com.happy.admin.dto.form.UserPostUpdateForm;
import com.happy.admin.dto.UserPostDto;
import com.happy.admin.service.IUserPostService;
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
 * 用户岗位关系 前端控制器
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */

@Validated
@RestController
@Api(tags="用户岗位关系")
@RequiredArgsConstructor
@RequestMapping("/user-post")
public class UserPostController {

    /**
     * 用户岗位关系 服务类
     */
    private final IUserPostService userPostServiceImpl;

    @ApiOperation(value = "新增用户岗位关系", notes = "新增用户岗位关系")
    @PostMapping
    public BaseResult<UserPostDto> add(@RequestBody UserPostAddForm userPostAddForm) {
       return BaseResult.success(userPostServiceImpl.save(userPostAddForm));
    }

    @ApiOperation(value = "删除用户岗位关系", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(userPostServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改用户岗位关系", notes = "修改指定用户岗位关系信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody UserPostUpdateForm userPostUpdateForm) {
       userPostUpdateForm.setId(id);
       return BaseResult.success(userPostServiceImpl.update(userPostUpdateForm));
    }

    @ApiOperation(value = "获取用户岗位关系", notes = "获取指定用户岗位关系信息")
    @GetMapping(value = "/{id}")
    public BaseResult<UserPostDto> get(@PathVariable String id) {
       return BaseResult.success(userPostServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索用户岗位关系", notes = "根据条件查询用户岗位关系信息")
    @PostMapping(value = "/list")
    public ListResult<UserPostDto> list(@RequestBody UserPostQryForm userPostQryForm) {
        return ListResult.success(userPostServiceImpl.list(userPostQryForm));
    }

    @ApiOperation(value = "分页搜索用户岗位关系", notes = "根据条件分页查询用户岗位关系信息")
    @PostMapping(value = "/page")
    public PageResult<UserPostDto> page(@RequestBody UserPostQryPageForm userPostQryPageForm) {
        IPage<UserPostDto> page = userPostServiceImpl.page(userPostQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
