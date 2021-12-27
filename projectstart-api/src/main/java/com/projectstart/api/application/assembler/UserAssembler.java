package com.projectstart.api.application.assembler;

import com.projectstart.api.application.command.UserSaveCommand;
import com.projectstart.api.domain.model.user.*;
import com.projectstart.api.domain.model.user.entity.User;
import org.apache.commons.lang3.StringUtils;

/**
 * @author shenguangyang
 * @date 2021-12-26 16:15
 */
public interface UserAssembler {
    static User toUserFrom(UserSaveCommand command) {
        Phone phone = null;
        Email email = null;
        if (StringUtils.isNotEmpty(command.getPhone())) {
            phone = new Phone(command.getPhone());
        }
        if (StringUtils.isNotEmpty(command.getEmail())) {
            email = new Email(command.getEmail());
        }
        return new User(
            null, phone, email, new Username(command.getUsername()), Password.create(command.getPassword())
        );
    }
}
