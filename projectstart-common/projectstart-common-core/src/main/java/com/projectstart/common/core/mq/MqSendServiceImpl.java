package com.projectstart.common.core.mq;

import com.projectstart.common.core.event.EmailMessage;
import com.projectstart.common.core.event.OrderCreateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:17
 */
@Service
public class MqSendServiceImpl implements MqSendService {
    @Autowired
    private MqSendService mqSendService;

    @Override
    public void send(EmailMessage emailMessage) {
        mqSendService.send(emailMessage);
    }

    @Override
    public void send(OrderCreateMessage message) {
        mqSendService.send(message);
    }
}