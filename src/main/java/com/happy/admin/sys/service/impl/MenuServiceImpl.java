package com.happy.admin.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.happy.admin.sys.dao.entity.Menu;
import com.happy.admin.sys.dao.mapper.MenuMapper;
import com.happy.admin.sys.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.admin.sys.dto.form.MenuAddForm;
import com.happy.admin.sys.dto.form.MenuQryForm;
import com.happy.admin.sys.dto.form.MenuQryPageForm;
import com.happy.admin.sys.dto.form.MenuUpdateForm;
import com.happy.admin.sys.dto.MenuDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {


     @Override
     public MenuDto get(String id) {
        Menu menu = this.getById(id);
        if(ObjectUtil.isNotNull(menu)){
            return menu.toDTO(MenuDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public MenuDto save(MenuAddForm menuAddForm) {
        Menu menu = menuAddForm.toEntity(Menu.class);
        this.save(menu);
        return menu.toDTO(MenuDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(MenuUpdateForm menuUpdateForm) {
        Menu menu = menuUpdateForm.toEntity(Menu.class);
        return this.updateById(menu);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<MenuDto> list(MenuQryForm menuQryForm) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<Menu> menus = this.list(queryWrapper);
        return HappyCodeUtil.copy(menus, MenuDto.class);

     }

     @Override
     public IPage<MenuDto> page(MenuQryPageForm menuQryPageForm) {
         QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(menuQryPageForm.getCurrent(), menuQryPageForm.getSize()),
                    queryWrapper).convert(menu->menu.toDTO(MenuDto.class));
      }

}
