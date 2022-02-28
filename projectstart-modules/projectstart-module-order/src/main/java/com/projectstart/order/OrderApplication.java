package com.projectstart.order;

import com.concise.component.mq.common.listener.MqListenerScan;
import com.concise.component.mq.rocketmq.enable.EnableRocketmq;
import com.projectstart.api.application.event.OrderCreateMessageListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shenguangyang
 * @date 2021-12-26 17:26
 */
@EnableRocketmq
@MqListenerScan(listener = {OrderCreateMessageListener.class}, basePackages = "com.projectstart.api.application.event")
@EnableFeignClients(basePackages = {"com.projectstart.api.infrastructure.externalapi"})
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
