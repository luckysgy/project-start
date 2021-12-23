package com.projectstart.api.application.command;

import lombok.Data;

/**
 * 邮件消息
 * @author shenguangyang
 * @date 2021-12-24 7:19
 */
@Data
public class EmailSendCommand {
    private String sender;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 接收人
     */
    private String receiver;
    /**
     * 创建时间
     */
    private Long createTime;
}
