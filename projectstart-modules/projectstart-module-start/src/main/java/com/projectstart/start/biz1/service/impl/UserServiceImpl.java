package com.projectstart.start.biz1.service.impl;

import com.projectstart.common.core.biz1.entity.UserDO;
import com.projectstart.start.biz1.dto.UpdatePasswordReqDTO;

import com.projectstart.common.core.base.mq.MqSendService;
import com.projectstart.start.biz1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shenguangyang
 * @date 2021-12-26 16:18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MqSendService mqSendService;

    @Override
    public void updatePassword(UpdatePasswordReqDTO request) {

    }

    @Override
    public void saveUser(UserDO user) {

    }
}
