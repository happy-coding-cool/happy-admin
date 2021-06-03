package com.happy.admin.service;

import com.happy.admin.dao.entity.OrgRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.admin.dto.form.OrgRoleAddForm;
import com.happy.admin.dto.form.OrgRoleQryForm;
import com.happy.admin.dto.form.OrgRoleQryPageForm;
import com.happy.admin.dto.form.OrgRoleUpdateForm;
import com.happy.admin.dto.OrgRoleDto;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 组织角色关系 服务类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
public interface IOrgRoleService extends IService<OrgRole> {

    /**
     * 获取组织角色关系
     *
     * @param id 组织角色关系id
     * @return OrgRoleDto
     */
    OrgRoleDto get(String id);

    /**
     * 获取组织角色关系
     *
     * @param orgRoleAddForm
     * @return OrgRoleDto
     */
    OrgRoleDto save(OrgRoleAddForm orgRoleAddForm);

    /**
     * 更新组织角色关系信息
     *
     * @param orgRoleUpdateForm
     * @return
     */
    boolean update(OrgRoleUpdateForm orgRoleUpdateForm);

    /**
     * 根据id删除组织角色关系
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询组织角色关系
     *
     * @param orgRoleQryForm
     * @return
     */
    List<OrgRoleDto> list(OrgRoleQryForm orgRoleQryForm);

    /**
     * 查询组织角色关系
     * @param orgRoleQryPageForm
     * @return
     */
    IPage<OrgRoleDto> page(OrgRoleQryPageForm orgRoleQryPageForm);
}
