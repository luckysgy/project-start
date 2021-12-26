package com.projectstart.api.infrastructure.mq;

import com.projectstart.api.application.event.EmailMessage;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:15
 */
public interface MqSendService {
    default void send(EmailMessage emailMessage) {}
}
