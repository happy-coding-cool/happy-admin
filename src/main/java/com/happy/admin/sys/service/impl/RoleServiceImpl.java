package com.happy.admin.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.happy.admin.sys.dao.entity.Role;
import com.happy.admin.sys.dao.mapper.RoleMapper;
import com.happy.admin.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.admin.sys.dto.form.RoleAddForm;
import com.happy.admin.sys.dto.form.RoleQryForm;
import com.happy.admin.sys.dto.form.RoleQryPageForm;
import com.happy.admin.sys.dto.form.RoleUpdateForm;
import com.happy.admin.sys.dto.RoleDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {


     @Override
     public RoleDto get(String id) {
        Role role = this.getById(id);
        if(ObjectUtil.isNotNull(role)){
            return role.toDTO(RoleDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public RoleDto save(RoleAddForm roleAddForm) {
        Role role = roleAddForm.toEntity(Role.class);
        this.save(role);
        return role.toDTO(RoleDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(RoleUpdateForm roleUpdateForm) {
        Role role = roleUpdateForm.toEntity(Role.class);
        return this.updateById(role);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<RoleDto> list(RoleQryForm roleQryForm) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<Role> roles = this.list(queryWrapper);
        return HappyCodeUtil.copy(roles, RoleDto.class);

     }

     @Override
     public IPage<RoleDto> page(RoleQryPageForm roleQryPageForm) {
         QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(roleQryPageForm.getCurrent(), roleQryPageForm.getSize()),
                    queryWrapper).convert(role->role.toDTO(RoleDto.class));
      }

}
