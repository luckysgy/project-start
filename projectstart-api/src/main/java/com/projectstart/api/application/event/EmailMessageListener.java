package com.projectstart.api.application.event;

import com.concise.component.mq.common.listener.MqListener;
import com.concise.component.mq.rocketmq.domain.RocketMqMessage;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 邮件消息监听者
 * @author shenguangyang
 * @date 2021-12-24 7:17
 */
@Component
@RocketMQMessageListener(
        nameServer = "${rocketmq.name-server}",
        topic = "${rocketmq.email.topic}",
        consumerGroup = "${rocketmq.email.group}",
        selectorExpression = "${rocketmq.email.tag}")
public class EmailMessageListener implements MqListener, RocketMQListener<RocketMqMessage<EmailMessage>> {
    private static final Logger log = LoggerFactory.getLogger(EmailMessageListener.class);

    @Override
    public void onMessage(RocketMqMessage<EmailMessage> mqMessage) {

    }
}
