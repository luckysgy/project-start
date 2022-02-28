package com.projectstart.news.application;

import com.projectstart.api.application.NewsService;
import com.projectstart.api.application.command.EmailSendCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:31
 */
@Service
public class NewsServiceImpl implements NewsService {
    private static final Logger log = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Override
    public void sendEmail(EmailSendCommand emailSendCommand) {
        log.info("start send email {}", emailSendCommand);
    }
}
