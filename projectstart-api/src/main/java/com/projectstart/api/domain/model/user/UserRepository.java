package com.projectstart.api.domain.model.user;

import com.projectstart.api.domain.model.user.entity.User;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:00
 */
public interface UserRepository {
    /**
     * 存储用户
     * @param user
     * @return
     */
    default int save(User user) { return -1;};

    /**
     * 查询用户
     * @param username 用户名
     * @return
     */
    default User find(Username username) { return null;}
}
