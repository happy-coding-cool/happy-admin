package com.happy.admin.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.happy.admin.sys.dao.entity.Dict;
import com.happy.admin.sys.dao.mapper.DictMapper;
import com.happy.admin.sys.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.admin.sys.dto.form.DictAddForm;
import com.happy.admin.sys.dto.form.DictQryForm;
import com.happy.admin.sys.dto.form.DictQryPageForm;
import com.happy.admin.sys.dto.form.DictUpdateForm;
import com.happy.admin.sys.dto.DictDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {


     @Override
     public DictDto get(String id) {
        Dict dict = this.getById(id);
        if(ObjectUtil.isNotNull(dict)){
            return dict.toDTO(DictDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public DictDto save(DictAddForm dictAddForm) {
        Dict dict = dictAddForm.toEntity(Dict.class);
        this.save(dict);
        return dict.toDTO(DictDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(DictUpdateForm dictUpdateForm) {
        Dict dict = dictUpdateForm.toEntity(Dict.class);
        return this.updateById(dict);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<DictDto> list(DictQryForm dictQryForm) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<Dict> dicts = this.list(queryWrapper);
        return HappyCodeUtil.copy(dicts, DictDto.class);

     }

     @Override
     public IPage<DictDto> page(DictQryPageForm dictQryPageForm) {
         QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(dictQryPageForm.getCurrent(), dictQryPageForm.getSize()),
                    queryWrapper).convert(dict->dict.toDTO(DictDto.class));
      }

}
