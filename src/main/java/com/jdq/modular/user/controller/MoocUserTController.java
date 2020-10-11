package com.jdq.modular.user.controller;


import com.jdq.auth.rest.common.CurrentUser;
import com.jdq.auth.rest.common.dto.input.MoocUserTListInput;
import com.jdq.auth.rest.common.vo.Result;
import com.jdq.auth.rest.modular.admin.controller.AdminController;
import com.jdq.modular.user.model.MoocUserT;
import com.jdq.modular.user.service.MoocUserTService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *   @description : MoocUserT 控制器
 *   ---------------------------------
 *   @author jindiqing
 *   @since 2020-10-10
 */
@RestController
@RequestMapping("/user")

public class MoocUserTController extends AdminController {

    @Autowired
    private MoocUserTService moocUserTService;


    @GetMapping("list")
    public Result getMoocUserTList(MoocUserTListInput input) {
	return moocUserTService.getMoocUserTList(input);
    }

    @GetMapping("info")
    public Result getMoocUserTInfo(@RequestParam Long id) {
	return moocUserTService.getMoocUserTInfo(id);
    }

    @PostMapping("add")
    public Result addMoocUserT(@RequestBody MoocUserT input) {
	String userId = CurrentUser.getCurrentUser();
	input.setModifier(userId);
	return moocUserTService.addMoocUserT(input);
    }


    @PostMapping("update")
    public Result updateMoocUserT(@RequestBody MoocUserT input) {
	input.setModifier(CurrentUser.getCurrentUser());
	return moocUserTService.updateMoocUserT(input);
    }


    @DeleteMapping("delete")
    public Result deleteMoocUserT(@RequestParam Long id) {
	return moocUserTService.deleteMoocUserT(id);
    }


}
