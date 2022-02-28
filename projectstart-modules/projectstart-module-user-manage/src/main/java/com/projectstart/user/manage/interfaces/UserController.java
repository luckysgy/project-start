package com.projectstart.user.manage.interfaces;

import com.concise.component.core.entity.response.Response;
import com.projectstart.api.application.UserService;
import com.projectstart.api.application.command.UserPasswordUpdateCommand;
import com.projectstart.api.application.command.UserSaveCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenguangyang
 * @date 2021-12-26 16:06
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/update/password")
    public Response updatePassword(@RequestBody UserPasswordUpdateCommand command) {
        userService.updatePassword(command);
        return Response.buildSuccess("更新成功");
    }

    @PostMapping("/")
    public Response save(@RequestBody UserSaveCommand command) {
        userService.save(command);
        return Response.buildSuccess("保存成功");
    }
}
