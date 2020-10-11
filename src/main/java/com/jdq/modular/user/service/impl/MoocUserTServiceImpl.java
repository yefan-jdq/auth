package com.jdq.modular.user.service.impl;


import com.jdq.auth.rest.common.dto.input.MoocUserTListInput;
import com.jdq.auth.rest.common.dto.output.PageResult;
import com.jdq.auth.rest.common.dto.output.ReturnUtils;
import com.jdq.auth.rest.common.util.DateUtil;
import com.jdq.auth.rest.common.vo.Result;
import com.jdq.modular.user.mapper.MoocUserTMapper;
import com.jdq.modular.user.model.MoocUserT;
import com.jdq.modular.user.service.MoocUserTService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jindiqing
 * @since 2020-10-10
 */
@Service
public class MoocUserTServiceImpl extends ServiceImpl<MoocUserTMapper, MoocUserT> implements MoocUserTService {
    /**
     * 分页获取列表接口
     *
     * @param input
     * @return
     */
    @Override
    public Result getMoocUserTList(MoocUserTListInput input){
        PageHelper.startPage(input.getPage(), input.getLimit());
        QueryWrapper<MoocUserT> wrapper = new QueryWrapper<>();
        PageResult<MoocUserT> res = PageResult.getPageResult(new PageInfo<>(this.list(wrapper)));
        return Result.successRet(res);
    }

    /**
     * 获取详情接口
     *
     * @param id
     * @return
     */
    @Override
    public Result getMoocUserTInfo(Long id){
        return Result.successRet(this.getById(id));
    }

    /**
     * 新增接口
     *
     * @param input
     * @return
     */
    @Override
    public Result addMoocUserT(MoocUserT input){
        Date date = new Date();
        input.setBeginTime(DateUtil.dateToLocalDateTime(date))
            .setUpdateTime(DateUtil.dateToLocalDateTime(date));
        input.insert();
        return Result.successRet(ReturnUtils.backObjId(input.getId()));
    }

    /**
     * 更新接口
     *
     * @param input
     * @return
     */
    @Override
    public Result updateMoocUserT(MoocUserT input){
        Date date = new Date();
        input.setUpdateTime(DateUtil.dateToLocalDateTime(date));
        input.updateById();
        return Result.successRet(ReturnUtils.backObjId(input.getId()));
    }

    /**
     * 删除接口
     *
     * @param id
     * @return
     */
    @Override
    public Result deleteMoocUserT(Long id){
        this.removeById(id);
        return Result.successRet();
    }

}
