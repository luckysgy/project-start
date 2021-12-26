package com.projectstart.api.application.event;

import lombok.Data;

import java.util.List;

/**
 * @author shenguangyang
 * @date 2021-12-26 18:49
 */
@Data
public class OrderCreateMessage {
    private List<Long> goodsIds;
}
