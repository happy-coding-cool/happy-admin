package com.happy.admin.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.happy.admin.sys.dao.entity.User;
import com.happy.admin.sys.dao.mapper.UserMapper;
import com.happy.admin.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.admin.sys.dto.form.UserAddForm;
import com.happy.admin.sys.dto.form.UserQryForm;
import com.happy.admin.sys.dto.form.UserQryPageForm;
import com.happy.admin.sys.dto.form.UserUpdateForm;
import com.happy.admin.sys.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author happycoding
 * @since 2021-05-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


     @Override
     public UserDto get(String id) {
        User user = this.getById(id);
        if(ObjectUtil.isNotNull(user)){
            return user.toDTO(UserDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public UserDto save(UserAddForm userAddForm) {
        User user = userAddForm.toEntity(User.class);
        this.save(user);
        return user.toDTO(UserDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(UserUpdateForm userUpdateForm) {
        User user = userUpdateForm.toEntity(User.class);
        return this.updateById(user);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<UserDto> list(UserQryForm userQryForm) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<User> users = this.list(queryWrapper);
        return HappyCodeUtil.copy(users, UserDto.class);

     }

     @Override
     public IPage<UserDto> page(UserQryPageForm userQryPageForm) {
         QueryWrapper<User> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(userQryPageForm.getCurrent(), userQryPageForm.getSize()),
                    queryWrapper).convert(user->user.toDTO(UserDto.class));
      }

}
