package com.projectstart.api.application.command;

import lombok.Data;

/**
 * @author shenguangyang
 * @date 2021-12-26 16:11
 */
@Data
public class UserPasswordUpdateCommand {
    private String oldPassword;
    private String newPassword;
}
