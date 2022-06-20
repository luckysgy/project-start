package com.projectstart.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 15. 【参考】各层命名规约：
 * A) Service/DAO 层方法命名规约
 * 1） 获取单个对象的方法用 get 做前缀。
 * 2） 获取多个对象的方法用 list 做前缀。
 * 3） 获取统计值的方法用 count 做前缀。
 * 4） 插入的方法用 save（推荐）或 insert 做前缀。
 * 5） 删除的方法用 remove（推荐）或 delete 做前缀。
 * 6） 修改的方法用 update 做前缀。
 *
 * B) 领域模型命名规约
 * 1） 数据对象：xxxDO，xxx 即为数据表名。
 * 2） 数据传输对象：xxxDTO，xxx 为业务领域相关的名称。
 * 3） 展示对象：xxxVO，xxx 一般为网页名称。
 * 4） POJO 是 DO/DTO/BO/VO 的统称，禁止命名成 xxxPOJO。
 * @author shenguangyang
 * @date 2021-12-24 7:09
 */
@SpringBootApplication
public class StartApplication {
    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    public static void main(String[] args) {
        // 不启动web
//        new SpringApplicationBuilder(StartApplication.class).web(WebApplicationType.NONE).run(args);
        SpringApplication.run(StartApplication.class, args);
    }
}
