package com.projectstart.start.biz1.service;

import com.projectstart.common.core.biz1.entity.UserDO;
import com.projectstart.start.biz1.dto.UpdatePasswordReqDTO;

/**
 * @author shenguangyang
 * @date 2021-12-26 16:09
 */
public interface UserService {
    /**
     * 更新用户密码
     */
    void updatePassword(UpdatePasswordReqDTO request);

    /**
     * 保存用户
     */
    default void saveUser(UserDO user) {}
}
