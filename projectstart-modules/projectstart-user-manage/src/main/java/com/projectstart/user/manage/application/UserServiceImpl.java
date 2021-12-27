package com.projectstart.user.manage.application;

import com.projectstart.api.application.UserService;
import com.projectstart.api.application.assembler.UserAssembler;
import com.projectstart.api.application.command.UserPasswordUpdateCommand;
import com.projectstart.api.application.command.UserSaveCommand;
import com.projectstart.api.application.event.EmailMessage;
import com.projectstart.api.domain.model.user.UserId;
import com.projectstart.api.domain.model.user.UserRepository;
import com.projectstart.api.domain.model.user.entity.User;
import com.projectstart.api.infrastructure.mq.MqSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shenguangyang
 * @date 2021-12-26 16:18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MqSendService mqSendService;

    @Override
    public void updatePassword(UserPasswordUpdateCommand command) {
        User user = userRepository.find(new UserId(1L));
        user.changePassword(command.getOldPassword(), command.getNewPassword());
        userRepository.store(user);

        // 发送邮件通知
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setContent("用户 id = 1 更新密码, 如果这不是本人操作请及时修改密码");
        mqSendService.send(emailMessage);
    }

    @Override
    public void save(UserSaveCommand command) {
        User user = UserAssembler.toUserFrom(command);
        userRepository.store(user);
    }
}
