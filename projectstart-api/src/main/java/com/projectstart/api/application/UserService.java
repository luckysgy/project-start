package com.projectstart.api.application;

import com.projectstart.api.application.command.UserPasswordUpdateCommand;
import com.projectstart.api.domain.model.user.Password;

/**
 * @author shenguangyang
 * @date 2021-12-26 16:09
 */
public interface UserService {
    /**
     * 更新用户密码
     * @param command 更新密码
     */
    default void updatePassword(UserPasswordUpdateCommand command) {} ;
}
