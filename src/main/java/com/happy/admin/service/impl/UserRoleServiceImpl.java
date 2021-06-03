package com.happy.admin.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.happy.admin.dao.entity.UserRole;
import com.happy.admin.dao.mapper.UserRoleMapper;
import com.happy.admin.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.admin.dto.form.UserRoleAddForm;
import com.happy.admin.dto.form.UserRoleQryForm;
import com.happy.admin.dto.form.UserRoleQryPageForm;
import com.happy.admin.dto.form.UserRoleUpdateForm;
import com.happy.admin.dto.UserRoleDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 用户角色关系 服务实现类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {


     @Override
     public UserRoleDto get(String id) {
        UserRole userRole = this.getById(id);
        if(ObjectUtil.isNotNull(userRole)){
            return userRole.toDTO(UserRoleDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public UserRoleDto save(UserRoleAddForm userRoleAddForm) {
        UserRole userRole = userRoleAddForm.toEntity(UserRole.class);
        this.save(userRole);
        return userRole.toDTO(UserRoleDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(UserRoleUpdateForm userRoleUpdateForm) {
        UserRole userRole = userRoleUpdateForm.toEntity(UserRole.class);
        return this.updateById(userRole);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<UserRoleDto> list(UserRoleQryForm userRoleQryForm) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<UserRole> userRoles = this.list(queryWrapper);
        return HappyCodeUtil.copy(userRoles, UserRoleDto.class);

     }

     @Override
     public IPage<UserRoleDto> page(UserRoleQryPageForm userRoleQryPageForm) {
         QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(userRoleQryPageForm.getCurrent(), userRoleQryPageForm.getSize()),
                    queryWrapper).convert(userRole->userRole.toDTO(UserRoleDto.class));
      }

}
