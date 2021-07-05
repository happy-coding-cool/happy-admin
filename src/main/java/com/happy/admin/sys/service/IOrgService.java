package com.happy.admin.sys.service;

import com.happy.admin.sys.dao.entity.Org;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.admin.sys.dto.form.OrgAddForm;
import com.happy.admin.sys.dto.form.OrgQryForm;
import com.happy.admin.sys.dto.form.OrgQryPageForm;
import com.happy.admin.sys.dto.form.OrgUpdateForm;
import com.happy.admin.sys.dto.OrgDto;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 组织 服务类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
public interface IOrgService extends IService<Org> {

    /**
     * 获取组织
     *
     * @param id 组织id
     * @return OrgDto
     */
    OrgDto get(String id);

    /**
     * 获取组织
     *
     * @param orgAddForm
     * @return OrgDto
     */
    OrgDto save(OrgAddForm orgAddForm);

    /**
     * 更新组织信息
     *
     * @param orgUpdateForm
     * @return
     */
    boolean update(OrgUpdateForm orgUpdateForm);

    /**
     * 根据id删除组织
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询组织
     *
     * @param orgQryForm
     * @return
     */
    List<OrgDto> list(OrgQryForm orgQryForm);

    /**
     * 查询组织
     * @param orgQryPageForm
     * @return
     */
    IPage<OrgDto> page(OrgQryPageForm orgQryPageForm);
}
