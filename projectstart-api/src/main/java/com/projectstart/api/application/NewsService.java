package com.projectstart.api.application;

import com.projectstart.api.application.command.EmailSendCommand;

/**
 * 消息服务
 * @author shenguangyang
 * @date 2021-12-24 7:18
 */
public interface NewsService {
    /**
     * 发送邮件
     */
    default void sendEmail(EmailSendCommand emailSendCommand) {}
}
