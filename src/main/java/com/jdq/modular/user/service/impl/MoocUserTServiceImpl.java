package com.jdq.modular.user.service.impl;


import com.jdq.auth.rest.common.dto.input.MoocUserTListInput;
import com.jdq.auth.rest.common.dto.output.PageResult;
import com.jdq.auth.rest.common.dto.output.ReturnUtils;
import com.jdq.auth.rest.common.exception.BizExceptionEnum;
import com.jdq.auth.rest.common.exception.GunsException;
import com.jdq.auth.rest.common.util.DateUtil;
import com.jdq.auth.rest.common.util.JWTUtil;
import com.jdq.auth.rest.common.util.MD5Util;
import com.jdq.auth.rest.common.vo.Result;
import com.jdq.auth.rest.modular.auth.util.JwtTokenUtil;
import com.jdq.modular.user.mapper.MoocUserTMapper;
import com.jdq.modular.user.model.MoocUserT;
import com.jdq.modular.user.service.MoocUserTService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MoocUserTMapper moocUserTMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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
        if(existUser(input.getUserName())) {
            throw new GunsException(BizExceptionEnum.GATEWAY_ERROR, "用户名已经被占用，不能创建");
        }
        Date date = new Date();
        input.setBeginTime(DateUtil.dateToLocalDateTime(date))
            .setUpdateTime(DateUtil.dateToLocalDateTime(date));
        input.insert();
        return Result.successRet(ReturnUtils.backObjId(input.getId()));
    }

    /**
     * 判断该用户名是否在数据库中已经存在
     * @param userName
     * @return
     */
    private boolean existUser(String userName) {
        var query = new QueryWrapper<MoocUserT>();
        query.eq("user_name", userName);
        return moocUserTMapper.selectCount(query) != 0;

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


    @Override
    public Result login(String userName, String password) {
        // 数据加密 【MD5混淆加密 + 盐值 -> Shiro加密】
        String md5Password = MD5Util.encrypt(password);
        var query = new QueryWrapper<MoocUserT>();
        query.eq("user_name", userName).eq("user_pwd", md5Password);
        MoocUserT moocUserT = moocUserTMapper.selectOne(query);
        if(moocUserT != null) {
            var toeken = jwtTokenUtil.generateToken(userName, md5Password);
            var token = JWTUtil.sign(userName, md5Password);
            return Result.successRet(token);
        } else {
            throw new GunsException(BizExceptionEnum.GATEWAY_ERROR, "账号或密码错误！");
        }
    }
}
