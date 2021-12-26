package com.projectstart.api.infrastructure.mq;

import com.projectstart.api.application.event.EmailMessage;
import com.projectstart.api.application.event.OrderCreateMessage;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:15
 */
public interface MqSendService {
    default void send(EmailMessage emailMessage) {}
    default void send(OrderCreateMessage message) {}
}
