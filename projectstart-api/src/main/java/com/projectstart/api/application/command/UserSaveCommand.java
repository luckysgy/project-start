package com.projectstart.api.application.command;

import lombok.Data;

/**
 * @author shenguangyang
 * @date 2021-12-28 7:44
 */
@Data
public class UserSaveCommand {
    private String password;
    private String username;
    private String email;
    private String phone;
}
