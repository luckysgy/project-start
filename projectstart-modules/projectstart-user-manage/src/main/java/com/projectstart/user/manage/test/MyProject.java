package com.projectstart.user.manage.test;

import org.springframework.stereotype.Component;

/**
 * @author shenguangyang
 * @date 2021-12-24 8:00
 */
@Component
@ConditionalOnMq(type = Enabled.TEST)
public class MyProject {
}
