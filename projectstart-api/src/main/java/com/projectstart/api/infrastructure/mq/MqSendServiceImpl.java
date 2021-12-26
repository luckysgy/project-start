package com.projectstart.api.infrastructure.mq;

import com.concise.component.mq.rocketmq.service.RocketMqSendService;
import com.projectstart.api.application.event.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:17
 */
@Service
public class MqSendServiceImpl implements MqSendService {
    @Autowired
    private RocketMqSendService rocketMqSendService;
    @Value("${rocketmq.email.topic}")
    private String EMAIL_TOPIC;
    @Value("${rocketmq.email.group}")
    private String EMAIL_GROUP;
    @Value("${rocketmq.email.tag}")
    private String EMAIL_TAG;

    @Override
    public void send(EmailMessage emailMessage) {
        rocketMqSendService.send(emailMessage, EMAIL_TOPIC, EMAIL_GROUP, EMAIL_TAG);
    }
}
