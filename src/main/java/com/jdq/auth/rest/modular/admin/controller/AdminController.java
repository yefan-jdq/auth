package com.jdq.auth.rest.modular.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {


    @GetMapping(value = "/getHello")
    public String sayHello() {
        return "hello world";
    }
}
