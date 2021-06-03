package com.happy.admin.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.happy.admin.dao.entity.Org;
import com.happy.admin.dao.mapper.OrgMapper;
import com.happy.admin.service.IOrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.admin.dto.form.OrgAddForm;
import com.happy.admin.dto.form.OrgQryForm;
import com.happy.admin.dto.form.OrgQryPageForm;
import com.happy.admin.dto.form.OrgUpdateForm;
import com.happy.admin.dto.OrgDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 组织 服务实现类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements IOrgService {


     @Override
     public OrgDto get(String id) {
        Org org = this.getById(id);
        if(ObjectUtil.isNotNull(org)){
            return org.toDTO(OrgDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public OrgDto save(OrgAddForm orgAddForm) {
        Org org = orgAddForm.toEntity(Org.class);
        this.save(org);
        return org.toDTO(OrgDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(OrgUpdateForm orgUpdateForm) {
        Org org = orgUpdateForm.toEntity(Org.class);
        return this.updateById(org);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<OrgDto> list(OrgQryForm orgQryForm) {
        QueryWrapper<Org> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<Org> orgs = this.list(queryWrapper);
        return HappyCodeUtil.copy(orgs, OrgDto.class);

     }

     @Override
     public IPage<OrgDto> page(OrgQryPageForm orgQryPageForm) {
         QueryWrapper<Org> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(orgQryPageForm.getCurrent(), orgQryPageForm.getSize()),
                    queryWrapper).convert(org->org.toDTO(OrgDto.class));
      }

}
