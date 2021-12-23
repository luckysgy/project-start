package com.projectstart.user.manage.infrastructure.persistence.repository;

import com.projectstart.api.domain.model.user.UserRepository;
import com.projectstart.api.domain.model.user.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:11
 */
@Component
public class UserRepositoryImpl implements UserRepository {

    @Override
    public int save(User user) {
        return UserRepository.super.save(user);
    }
}
