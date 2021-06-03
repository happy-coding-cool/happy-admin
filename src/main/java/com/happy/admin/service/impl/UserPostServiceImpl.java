package com.happy.admin.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.happy.admin.dao.entity.UserPost;
import com.happy.admin.dao.mapper.UserPostMapper;
import com.happy.admin.service.IUserPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.admin.dto.form.UserPostAddForm;
import com.happy.admin.dto.form.UserPostQryForm;
import com.happy.admin.dto.form.UserPostQryPageForm;
import com.happy.admin.dto.form.UserPostUpdateForm;
import com.happy.admin.dto.UserPostDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 用户岗位关系 服务实现类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements IUserPostService {


     @Override
     public UserPostDto get(String id) {
        UserPost userPost = this.getById(id);
        if(ObjectUtil.isNotNull(userPost)){
            return userPost.toDTO(UserPostDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public UserPostDto save(UserPostAddForm userPostAddForm) {
        UserPost userPost = userPostAddForm.toEntity(UserPost.class);
        this.save(userPost);
        return userPost.toDTO(UserPostDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(UserPostUpdateForm userPostUpdateForm) {
        UserPost userPost = userPostUpdateForm.toEntity(UserPost.class);
        return this.updateById(userPost);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<UserPostDto> list(UserPostQryForm userPostQryForm) {
        QueryWrapper<UserPost> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<UserPost> userPosts = this.list(queryWrapper);
        return HappyCodeUtil.copy(userPosts, UserPostDto.class);

     }

     @Override
     public IPage<UserPostDto> page(UserPostQryPageForm userPostQryPageForm) {
         QueryWrapper<UserPost> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(userPostQryPageForm.getCurrent(), userPostQryPageForm.getSize()),
                    queryWrapper).convert(userPost->userPost.toDTO(UserPostDto.class));
      }

}
