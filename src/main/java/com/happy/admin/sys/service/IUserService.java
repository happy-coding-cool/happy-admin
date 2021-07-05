package com.happy.admin.sys.service;

import com.happy.admin.sys.dao.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.admin.sys.dto.form.UserAddForm;
import com.happy.admin.sys.dto.form.UserQryForm;
import com.happy.admin.sys.dto.form.UserQryPageForm;
import com.happy.admin.sys.dto.form.UserUpdateForm;
import com.happy.admin.sys.dto.UserDto;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author happycoding
 * @since 2021-05-10
 */
public interface IUserService extends IService<User> {

    /**
     * 获取用户
     *
     * @param id 用户id
     * @return UserDto
     */
    UserDto get(String id);

    /**
     * 获取用户
     *
     * @param userAddForm
     * @return UserDto
     */
    UserDto save(UserAddForm userAddForm);

    /**
     * 更新用户信息
     *
     * @param userUpdateForm
     * @return
     */
    boolean update(UserUpdateForm userUpdateForm);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询用户
     *
     * @param userQryForm
     * @return
     */
    List<UserDto> list(UserQryForm userQryForm);

    /**
     * 查询用户
     * @param userQryPageForm
     * @return
     */
    IPage<UserDto> page(UserQryPageForm userQryPageForm);
}
