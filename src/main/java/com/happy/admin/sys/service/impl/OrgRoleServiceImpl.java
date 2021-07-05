package com.happy.admin.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.happy.admin.sys.dao.entity.OrgRole;
import com.happy.admin.sys.dao.mapper.OrgRoleMapper;
import com.happy.admin.sys.service.IOrgRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.admin.sys.dto.form.OrgRoleAddForm;
import com.happy.admin.sys.dto.form.OrgRoleQryForm;
import com.happy.admin.sys.dto.form.OrgRoleQryPageForm;
import com.happy.admin.sys.dto.form.OrgRoleUpdateForm;
import com.happy.admin.sys.dto.OrgRoleDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 组织角色关系 服务实现类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Service
public class OrgRoleServiceImpl extends ServiceImpl<OrgRoleMapper, OrgRole> implements IOrgRoleService {


     @Override
     public OrgRoleDto get(String id) {
        OrgRole orgRole = this.getById(id);
        if(ObjectUtil.isNotNull(orgRole)){
            return orgRole.toDTO(OrgRoleDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public OrgRoleDto save(OrgRoleAddForm orgRoleAddForm) {
        OrgRole orgRole = orgRoleAddForm.toEntity(OrgRole.class);
        this.save(orgRole);
        return orgRole.toDTO(OrgRoleDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(OrgRoleUpdateForm orgRoleUpdateForm) {
        OrgRole orgRole = orgRoleUpdateForm.toEntity(OrgRole.class);
        return this.updateById(orgRole);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<OrgRoleDto> list(OrgRoleQryForm orgRoleQryForm) {
        QueryWrapper<OrgRole> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<OrgRole> orgRoles = this.list(queryWrapper);
        return HappyCodeUtil.copy(orgRoles, OrgRoleDto.class);

     }

     @Override
     public IPage<OrgRoleDto> page(OrgRoleQryPageForm orgRoleQryPageForm) {
         QueryWrapper<OrgRole> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(orgRoleQryPageForm.getCurrent(), orgRoleQryPageForm.getSize()),
                    queryWrapper).convert(orgRole->orgRole.toDTO(OrgRoleDto.class));
      }

}
