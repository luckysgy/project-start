package com.projectstart.api.application.event;

import com.concise.component.mq.common.listener.MqListener;
import com.concise.component.mq.rocketmq.domain.RocketMqMessage;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author shenguangyang
 * @date 2021-12-26 18:52
 */
@Component
@RocketMQMessageListener(
        nameServer = "${rocketmq.name-server}",
        topic = "${rocketmq.order.topic}",
        consumerGroup = "${rocketmq.order.group}",
        selectorExpression = "${rocketmq.order.tag}")
public class OrderCreateMessageListener implements MqListener, RocketMQListener<RocketMqMessage<OrderCreateMessage>> {
    private static final Logger log = LoggerFactory.getLogger(OrderCreateMessageListener.class);
    @Override
    public void onMessage(RocketMqMessage<OrderCreateMessage> mqMessage) {
        log.info("监听到订单创建消息: {}", mqMessage.getContent());
    }
}
