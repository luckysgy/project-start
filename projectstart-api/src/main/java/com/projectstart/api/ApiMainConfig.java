package com.projectstart.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

/**
 * 存放工程所需要的接口以及相关实体, 这一层完全面向接口编程
 * @author shenguangyang
 * @date 2021-12-24 6:53
 */
@ComponentScan(basePackages = "com.projectstart.api")
public class ApiMainConfig {
    private static final Logger log = LoggerFactory.getLogger(ApiMainConfig.class);

    @PostConstruct
    public void init() {
        log.info("init com.projectstart.api");
    }
}
