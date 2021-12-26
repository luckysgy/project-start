package com.projectstart.api.application.command;

import lombok.Data;

import java.util.List;

/**
 * 创建订单命令
 * @author shenguangyang
 * @date 2021-12-26 17:38
 */
@Data
public class OrderCreateCommand {
    private List<Long> goodsIds;
}
