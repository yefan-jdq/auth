package com.jdq.auth.rest.modular.auth.controller;


import com.jdq.auth.rest.modular.auth.controller.dto.AuthRequest;
import com.jdq.auth.rest.modular.auth.controller.dto.AuthResponse;
import com.jdq.auth.rest.modular.auth.util.JwtTokenUtil;
import com.jdq.auth.rest.modular.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseVO createAuthenticationToken(AuthRequest authRequest) {

        boolean validate = false;
        // 去掉guns自身携带的用户名密码验证机制，使用我们自己的
        if("haha".equals(authRequest.getUserName()) || "haha".equals(authRequest.getPassword())) {
            validate = true;
        }
        if (validate) {
            // randomKey和token已经生成完毕
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName()+authRequest.getPassword(), randomKey);
            // 返回值
            return ResponseVO.success(new AuthResponse(token, randomKey));
        } else {
            return ResponseVO.serviceFail("用户名或密码错误");
        }
    }
}

