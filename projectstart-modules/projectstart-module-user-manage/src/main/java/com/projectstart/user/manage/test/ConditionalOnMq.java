package com.projectstart.user.manage.test;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 存储类型条件判断器
 * 可以用在方法和类上
 * @author shenguangyang
 * @date 2021/7/17 13:47
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ConditionalOnMq {
    /**
     * 存储类型
     */
    Enabled type();
}
