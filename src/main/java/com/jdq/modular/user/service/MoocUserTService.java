package com.jdq.modular.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jdq.auth.rest.common.dto.input.MoocUserTListInput;
import com.jdq.auth.rest.common.vo.Result;
import com.jdq.modular.user.model.MoocUserT;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jindiqing
 * @since 2020-10-10
 */
public interface MoocUserTService extends IService<MoocUserT> {
    /**
     * 分页获取列表接口
     *
     * @param input
     * @return
     */
    Result getMoocUserTList(MoocUserTListInput input);

    /**
     * 获取详情接口
     *
     * @param id
     * @return
     */
    Result getMoocUserTInfo(Long id);

    /**
     * 新增接口
     *
     * @param input
     * @return
     */
    Result addMoocUserT(MoocUserT input);

    /**
     * 更新接口
     *
     * @param input
     * @return
     */
    Result updateMoocUserT(MoocUserT input);

    /**
     * 删除接口
     *
     * @param id
     * @return
     */
    Result deleteMoocUserT(Long id);

    /**
     * 登入接口
     * @param userName
     * @param password
     * @return
     */
    Result login(String userName, String password);

}
