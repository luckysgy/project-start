package com.projectstart.api.application.event;

import com.projectstart.api.application.NewsService;
import com.projectstart.api.application.assembler.EmailAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 邮件消息监听者
 * @author shenguangyang
 * @date 2021-12-24 7:17
 */
@Component
public class EmailMessageListener {
    @Autowired
    private NewsService newsService;

    public void onMessage(EmailMessage emailMessage) {
        newsService.sendEmail(EmailAssembler.toEmailSendCommandFrom(emailMessage));
    }
}
