package com.happy.admin.sys.service;

import com.happy.admin.sys.dao.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.admin.sys.dto.form.PostAddForm;
import com.happy.admin.sys.dto.form.PostQryForm;
import com.happy.admin.sys.dto.form.PostQryPageForm;
import com.happy.admin.sys.dto.form.PostUpdateForm;
import com.happy.admin.sys.dto.PostDto;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 岗位 服务类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
public interface IPostService extends IService<Post> {

    /**
     * 获取岗位
     *
     * @param id 岗位id
     * @return PostDto
     */
    PostDto get(String id);

    /**
     * 获取岗位
     *
     * @param postAddForm
     * @return PostDto
     */
    PostDto save(PostAddForm postAddForm);

    /**
     * 更新岗位信息
     *
     * @param postUpdateForm
     * @return
     */
    boolean update(PostUpdateForm postUpdateForm);

    /**
     * 根据id删除岗位
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询岗位
     *
     * @param postQryForm
     * @return
     */
    List<PostDto> list(PostQryForm postQryForm);

    /**
     * 查询岗位
     * @param postQryPageForm
     * @return
     */
    IPage<PostDto> page(PostQryPageForm postQryPageForm);
}
