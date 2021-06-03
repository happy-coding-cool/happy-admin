package com.happy.admin.service;

import com.happy.admin.dao.entity.UserPost;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.admin.dto.form.UserPostAddForm;
import com.happy.admin.dto.form.UserPostQryForm;
import com.happy.admin.dto.form.UserPostQryPageForm;
import com.happy.admin.dto.form.UserPostUpdateForm;
import com.happy.admin.dto.UserPostDto;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 用户岗位关系 服务类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
public interface IUserPostService extends IService<UserPost> {

    /**
     * 获取用户岗位关系
     *
     * @param id 用户岗位关系id
     * @return UserPostDto
     */
    UserPostDto get(String id);

    /**
     * 获取用户岗位关系
     *
     * @param userPostAddForm
     * @return UserPostDto
     */
    UserPostDto save(UserPostAddForm userPostAddForm);

    /**
     * 更新用户岗位关系信息
     *
     * @param userPostUpdateForm
     * @return
     */
    boolean update(UserPostUpdateForm userPostUpdateForm);

    /**
     * 根据id删除用户岗位关系
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询用户岗位关系
     *
     * @param userPostQryForm
     * @return
     */
    List<UserPostDto> list(UserPostQryForm userPostQryForm);

    /**
     * 查询用户岗位关系
     * @param userPostQryPageForm
     * @return
     */
    IPage<UserPostDto> page(UserPostQryPageForm userPostQryPageForm);
}
