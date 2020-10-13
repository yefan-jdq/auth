package com.jdq.modular.user.dto;


import com.jdq.modular.user.model.MoocUserT;
import lombok.Data;
import com.jdq.auth.rest.common.util.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class MoocUserCreateInput {

    @NotNull(message = "账号不能为空")
    @Size(min = 5, max = 32, message = "账号错误")
    private String userName;

    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 32, message = "密码错误")
    private String password;

    private String phone;

    private String email;

    public MoocUserT moocUserAdapter(String modifierId) {
        MoocUserT user = new MoocUserT();
        user.setUserId(UUIDUtil.genUuid()).setUserName(userName)
                .setUserPwd(MD5Util.encrypt(password)).setUserPhone(phone).setEmail(email);
        return user;
    }
}
