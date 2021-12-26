package com.projectstart.news;

import com.concise.component.mq.common.listener.MqListenerScan;
import com.concise.component.mq.rocketmq.enable.EnableRocketmq;
import com.projectstart.api.application.event.EmailMessageListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shenguangyang
 * @date 2021-12-26 16:48
 */
@MqListenerScan(listener = {EmailMessageListener.class}, basePackages = "com.projectstart.api.application.event")
@EnableRocketmq
@SpringBootApplication
public class NewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewsApplication.class, args);
    }
}
