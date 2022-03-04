package com.projectstart.common.core.mq;

import com.projectstart.common.core.event.EmailMessage;
import com.projectstart.common.core.event.OrderCreateMessage;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:15
 */
public interface MqSendService {
    default void send(EmailMessage emailMessage) {}
    default void send(OrderCreateMessage message) {}
}
