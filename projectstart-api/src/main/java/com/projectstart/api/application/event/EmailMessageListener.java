package com.projectstart.api.application.event;

import com.concise.component.core.exception.Assert;
import com.concise.component.mq.common.listener.MqListener;
import com.concise.component.mq.rocketmq.domain.RocketMqMessage;
import com.projectstart.api.application.NewsService;
import com.projectstart.api.application.assembler.EmailAssembler;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired(required = false)
    private NewsService newsService;

    @Override
    public void onMessage(RocketMqMessage<EmailMessage> mqMessage) {
        Assert.notNull(newsService, "newsService == null");
        newsService.sendEmail(EmailAssembler.toEmailSendCommandFrom(mqMessage.getContent()));
    }
}
