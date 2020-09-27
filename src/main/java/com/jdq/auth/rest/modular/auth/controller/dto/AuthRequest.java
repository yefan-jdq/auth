package com.jdq.auth.rest.modular.auth.controller.dto;

import lombok.Data;

/**
 * 认证的请求dto
 *
 */

@Data
public class AuthRequest {

    private String userName;
    private String password;

}
