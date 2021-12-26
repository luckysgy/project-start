package com.projectstart.api.domain.model.order.entity;

import com.projectstart.api.domain.model.order.OrderId;
import com.projectstart.api.domain.model.order.SerialNumber;
import lombok.Getter;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:27
 */
@Getter
public class Order {
    private final OrderId orderId;
    private final SerialNumber serialNumber;

    public Order(OrderId orderId, SerialNumber serialNumber) {
        this.orderId = orderId;
        this.serialNumber = serialNumber;
    }
}
