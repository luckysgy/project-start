package com.projectstart.common.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

/**
 * @author shenguangyang
 * @date 2022-03-04 20:33
 */
@ComponentScan(basePackages = "com.projectstart.common.core")
public class CommonCoreMainConfig {
    private static final Logger log = LoggerFactory.getLogger(CommonCoreMainConfig.class);

    @PostConstruct
    public void init() {
        log.info("init com.projectstart.common.core");
    }
}
