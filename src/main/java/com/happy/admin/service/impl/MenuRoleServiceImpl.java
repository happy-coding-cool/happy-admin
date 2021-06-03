package com.happy.admin.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.happy.admin.dao.entity.MenuRole;
import com.happy.admin.dao.mapper.MenuRoleMapper;
import com.happy.admin.service.IMenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.admin.dto.form.MenuRoleAddForm;
import com.happy.admin.dto.form.MenuRoleQryForm;
import com.happy.admin.dto.form.MenuRoleQryPageForm;
import com.happy.admin.dto.form.MenuRoleUpdateForm;
import com.happy.admin.dto.MenuRoleDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 菜单角色关系 服务实现类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {


     @Override
     public MenuRoleDto get(String id) {
        MenuRole menuRole = this.getById(id);
        if(ObjectUtil.isNotNull(menuRole)){
            return menuRole.toDTO(MenuRoleDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public MenuRoleDto save(MenuRoleAddForm menuRoleAddForm) {
        MenuRole menuRole = menuRoleAddForm.toEntity(MenuRole.class);
        this.save(menuRole);
        return menuRole.toDTO(MenuRoleDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(MenuRoleUpdateForm menuRoleUpdateForm) {
        MenuRole menuRole = menuRoleUpdateForm.toEntity(MenuRole.class);
        return this.updateById(menuRole);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<MenuRoleDto> list(MenuRoleQryForm menuRoleQryForm) {
        QueryWrapper<MenuRole> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<MenuRole> menuRoles = this.list(queryWrapper);
        return HappyCodeUtil.copy(menuRoles, MenuRoleDto.class);

     }

     @Override
     public IPage<MenuRoleDto> page(MenuRoleQryPageForm menuRoleQryPageForm) {
         QueryWrapper<MenuRole> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(menuRoleQryPageForm.getCurrent(), menuRoleQryPageForm.getSize()),
                    queryWrapper).convert(menuRole->menuRole.toDTO(MenuRoleDto.class));
      }

}
