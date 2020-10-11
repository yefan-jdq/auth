package com.jdq.modular.user.mapper;

import com.jdq.modular.user.model.MoocUserT;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author jindiqing
 * @since 2020-10-10
 */
@Mapper
@Component
public interface MoocUserTMapper extends BaseMapper<MoocUserT> {

}
