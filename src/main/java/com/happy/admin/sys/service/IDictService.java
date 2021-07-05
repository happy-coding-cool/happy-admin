package com.happy.admin.sys.service;

import com.happy.admin.sys.dao.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.admin.sys.dto.form.DictAddForm;
import com.happy.admin.sys.dto.form.DictQryForm;
import com.happy.admin.sys.dto.form.DictQryPageForm;
import com.happy.admin.sys.dto.form.DictUpdateForm;
import com.happy.admin.sys.dto.DictDto;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author lanlanhappy
 * @since 2021-06-03
 */
public interface IDictService extends IService<Dict> {

    /**
     * 获取数据字典
     *
     * @param id 数据字典id
     * @return DictDto
     */
    DictDto get(String id);

    /**
     * 获取数据字典
     *
     * @param dictAddForm
     * @return DictDto
     */
    DictDto save(DictAddForm dictAddForm);

    /**
     * 更新数据字典信息
     *
     * @param dictUpdateForm
     * @return
     */
    boolean update(DictUpdateForm dictUpdateForm);

    /**
     * 根据id删除数据字典
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询数据字典
     *
     * @param dictQryForm
     * @return
     */
    List<DictDto> list(DictQryForm dictQryForm);

    /**
     * 查询数据字典
     * @param dictQryPageForm
     * @return
     */
    IPage<DictDto> page(DictQryPageForm dictQryPageForm);
}
