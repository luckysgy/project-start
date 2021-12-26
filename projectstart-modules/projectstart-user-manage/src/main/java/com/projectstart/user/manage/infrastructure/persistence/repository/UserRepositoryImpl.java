package com.projectstart.user.manage.infrastructure.persistence.repository;

import com.projectstart.api.domain.model.user.UserId;
import com.projectstart.api.domain.model.user.UserRepository;
import com.projectstart.api.domain.model.user.entity.User;
import com.projectstart.api.infrastructure.persistence.converter.UserConverter;
import com.projectstart.api.infrastructure.persistence.entity.UserDO;
import com.projectstart.api.infrastructure.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:11
 */
@Component
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int store(User user) {
        if (user.getId() == null) {
            return userMapper.insert(UserConverter.toUserDOFrom(user));
        }
        return userMapper.updateById(UserConverter.toUserDOFrom(user));
    }

    @Override
    public User find(UserId userId) {
        UserDO userDO = userMapper.selectById(userId.getValue());
        return UserConverter.toUserFrom(userDO);
    }
}
