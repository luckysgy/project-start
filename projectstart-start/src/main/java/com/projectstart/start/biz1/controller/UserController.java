package com.projectstart.start.biz1.controller;

import com.concise.component.core.entity.response.Response;
import com.projectstart.start.biz1.model.dto.UpdatePasswordReqDTO;
import com.projectstart.start.biz1.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shenguangyang
 * @date 2021-12-26 16:06
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/update/password")
    public Response updatePassword(@RequestBody UpdatePasswordReqDTO updatePasswordReqDTO) {
        userService.updatePassword(updatePasswordReqDTO);
        return Response.buildSuccess("更新成功");
    }

}
