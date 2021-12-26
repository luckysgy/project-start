package com.projectstart.api.domain.specification;

import com.concise.component.core.exception.BizException;
import com.concise.component.ddd.AbstractSpecification;
import com.projectstart.api.domain.model.user.UserRepository;
import com.projectstart.api.domain.model.user.entity.User;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:41
 */
public class UserUpdateSpecification extends AbstractSpecification<User> {
    private final UserRepository userRepository;

    public UserUpdateSpecification(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        User userFromDb = userRepository.find(user.getId());
        if (userFromDb == null) {
            throw new BizException("更新用户不存在");
        }
        return true;
    }
}
