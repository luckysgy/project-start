package com.projectstart.user.manage;

import com.projectstart.api.application.event.EmailMessage;
import com.projectstart.api.application.event.EmailMessageListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:44
 */
@SpringBootTest
public class EmailSenderTest {
    @Autowired
    private EmailMessageListener emailMessageListener;

    @Test
    public void test() {
        emailMessageListener.onMessage(new EmailMessage());
    }
}
