package com.projectstart.api.infrastructure.persistence.converter;

import com.concise.component.core.exception.BizException;
import com.projectstart.api.domain.model.user.*;
import com.projectstart.api.domain.model.user.entity.User;
import com.projectstart.api.infrastructure.persistence.entity.UserDO;

/**
 * @author shenguangyang
 * @date 2021-12-26 15:38
 */
public interface UserConverter {
    static User toUserFrom(UserDO from) {
        if (from == null) {
            throw new BizException("用户不存在");
        }
        return new User(
                new UserId(from.getId()), new Phone(from.getPhone()), new Email(from.getEmail()), new Username(from.getUsername()),
                new Password(from.getPassword(), from.getSalt())
        );
    }

    static UserDO toUserDOFrom(User user) {
        UserDO userDO = new UserDO();
        userDO.setId(user.getId().getValue());
        userDO.setPhone(user.getPhone().getValue());
        userDO.setEmail(user.getEmail().getValue());
        userDO.setUsername(user.getUsername().getValue());
        userDO.setPassword(user.getPassword().getPassword());
        return userDO;
    }
}
