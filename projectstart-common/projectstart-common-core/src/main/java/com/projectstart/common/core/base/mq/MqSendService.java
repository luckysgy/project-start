package com.projectstart.common.core.base.mq;

import com.projectstart.common.core.biz1.event.EmailMessage;
import com.projectstart.common.core.biz1.event.OrderCreateMessage;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:15
 */
public interface MqSendService {
    default void send(EmailMessage emailMessage) {}
    default void send(OrderCreateMessage message) {}
}
