package com.projectstart.api.application.assembler;

import com.projectstart.api.application.command.EmailSendCommand;
import com.projectstart.api.application.event.EmailMessage;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:22
 */
public interface EmailAssembler {
    static EmailSendCommand toEmailSendCommandFrom(EmailMessage emailMessage) {
        EmailSendCommand emailSendCommand = new EmailSendCommand();
        emailSendCommand.setSender(emailMessage.getSender());
        emailSendCommand.setContent(emailMessage.getContent());
        emailSendCommand.setReceiver(emailMessage.getReceiver());
        emailSendCommand.setCreateTime(emailMessage.getCreateTime());
        return emailSendCommand;
    }
}
