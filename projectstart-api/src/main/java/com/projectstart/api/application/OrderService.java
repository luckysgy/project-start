package com.projectstart.api.application;

import com.projectstart.api.application.command.OrderCreateCommand;

/**
 * @author shenguangyang
 * @date 2021-12-26 17:40
 */
public interface OrderService {
    default void createOrder(OrderCreateCommand command) {}
}
