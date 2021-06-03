package com.happy.admin.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.happy.admin.dao.entity.DictDetail;
import com.happy.admin.dao.mapper.DictDetailMapper;
import com.happy.admin.service.IDictDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.admin.dto.form.DictDetailAddForm;
import com.happy.admin.dto.form.DictDetailQryForm;
import com.happy.admin.dto.form.DictDetailQryPageForm;
import com.happy.admin.dto.form.DictDetailUpdateForm;
import com.happy.admin.dto.DictDetailDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 数据字典详情 服务实现类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Service
public class DictDetailServiceImpl extends ServiceImpl<DictDetailMapper, DictDetail> implements IDictDetailService {


     @Override
     public DictDetailDto get(String id) {
        DictDetail dictDetail = this.getById(id);
        if(ObjectUtil.isNotNull(dictDetail)){
            return dictDetail.toDTO(DictDetailDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public DictDetailDto save(DictDetailAddForm dictDetailAddForm) {
        DictDetail dictDetail = dictDetailAddForm.toEntity(DictDetail.class);
        this.save(dictDetail);
        return dictDetail.toDTO(DictDetailDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(DictDetailUpdateForm dictDetailUpdateForm) {
        DictDetail dictDetail = dictDetailUpdateForm.toEntity(DictDetail.class);
        return this.updateById(dictDetail);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<DictDetailDto> list(DictDetailQryForm dictDetailQryForm) {
        QueryWrapper<DictDetail> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<DictDetail> dictDetails = this.list(queryWrapper);
        return HappyCodeUtil.copy(dictDetails, DictDetailDto.class);

     }

     @Override
     public IPage<DictDetailDto> page(DictDetailQryPageForm dictDetailQryPageForm) {
         QueryWrapper<DictDetail> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(dictDetailQryPageForm.getCurrent(), dictDetailQryPageForm.getSize()),
                    queryWrapper).convert(dictDetail->dictDetail.toDTO(DictDetailDto.class));
      }

}
