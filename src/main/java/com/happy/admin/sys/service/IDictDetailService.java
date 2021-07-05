package com.happy.admin.sys.service;

import com.happy.admin.sys.dao.entity.DictDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.admin.sys.dto.form.DictDetailAddForm;
import com.happy.admin.sys.dto.form.DictDetailQryForm;
import com.happy.admin.sys.dto.form.DictDetailQryPageForm;
import com.happy.admin.sys.dto.form.DictDetailUpdateForm;
import com.happy.admin.sys.dto.DictDetailDto;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 数据字典详情 服务类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
public interface IDictDetailService extends IService<DictDetail> {

    /**
     * 获取数据字典详情
     *
     * @param id 数据字典详情id
     * @return DictDetailDto
     */
    DictDetailDto get(String id);

    /**
     * 获取数据字典详情
     *
     * @param dictDetailAddForm
     * @return DictDetailDto
     */
    DictDetailDto save(DictDetailAddForm dictDetailAddForm);

    /**
     * 更新数据字典详情信息
     *
     * @param dictDetailUpdateForm
     * @return
     */
    boolean update(DictDetailUpdateForm dictDetailUpdateForm);

    /**
     * 根据id删除数据字典详情
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询数据字典详情
     *
     * @param dictDetailQryForm
     * @return
     */
    List<DictDetailDto> list(DictDetailQryForm dictDetailQryForm);

    /**
     * 查询数据字典详情
     * @param dictDetailQryPageForm
     * @return
     */
    IPage<DictDetailDto> page(DictDetailQryPageForm dictDetailQryPageForm);
}
