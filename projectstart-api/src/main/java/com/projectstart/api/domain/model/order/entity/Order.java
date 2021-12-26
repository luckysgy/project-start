package com.projectstart.api.domain.model.order.entity;

import com.projectstart.api.domain.model.order.OrderId;
import lombok.Getter;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:27
 */
@Getter
public class Order {
    private final OrderId orderId;

    public Order(OrderId orderId) {
        this.orderId = orderId;
    }
}
