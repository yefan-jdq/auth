package com.jdq.modular.user.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserLoginInput {

    @NotNull(message = "账号不能为空")
    @Size(min = 5, message = "账号长度错误")
    private String username;

    @NotNull(message = "密码不能为空")
    @Size(min = 6, message = "密码长度错误")
    private String password;

}
