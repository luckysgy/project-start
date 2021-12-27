package com.projectstart.user.manage;

import com.concise.component.datasource.mybatisplus.register.EnableMybatisPlus;
import com.concise.component.mq.rocketmq.enable.EnableRocketmq;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:09
 */
@EnableMybatisPlus
@EnableRocketmq
@SpringBootApplication
@MapperScan(basePackages = "com.projectstart.api.infrastructure.persistence.mapper")
public class UserManageApplication {
    private static final Logger log = LoggerFactory.getLogger(UserManageApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserManageApplication.class, args);
    }
}
