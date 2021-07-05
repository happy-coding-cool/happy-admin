package com.happy.admin.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.happy.admin.sys.dao.entity.Post;
import com.happy.admin.sys.dao.mapper.PostMapper;
import com.happy.admin.sys.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.admin.sys.dto.form.PostAddForm;
import com.happy.admin.sys.dto.form.PostQryForm;
import com.happy.admin.sys.dto.form.PostQryPageForm;
import com.happy.admin.sys.dto.form.PostUpdateForm;
import com.happy.admin.sys.dto.PostDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 岗位 服务实现类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {


     @Override
     public PostDto get(String id) {
        Post post = this.getById(id);
        if(ObjectUtil.isNotNull(post)){
            return post.toDTO(PostDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public PostDto save(PostAddForm postAddForm) {
        Post post = postAddForm.toEntity(Post.class);
        this.save(post);
        return post.toDTO(PostDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(PostUpdateForm postUpdateForm) {
        Post post = postUpdateForm.toEntity(Post.class);
        return this.updateById(post);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<PostDto> list(PostQryForm postQryForm) {
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<Post> posts = this.list(queryWrapper);
        return HappyCodeUtil.copy(posts, PostDto.class);

     }

     @Override
     public IPage<PostDto> page(PostQryPageForm postQryPageForm) {
         QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(postQryPageForm.getCurrent(), postQryPageForm.getSize()),
                    queryWrapper).convert(post->post.toDTO(PostDto.class));
      }

}
