package com.projectstart.api.infrastructure.persistence.converter;

import com.projectstart.api.domain.model.order.OrderId;
import com.projectstart.api.domain.model.order.SerialNumber;
import com.projectstart.api.domain.model.order.entity.Order;
import com.projectstart.api.infrastructure.persistence.entity.OrderDO;

/**
 * @author shenguangyang
 * @date 2021-12-26 15:34
 */
public interface OrderConverter {
    static Order toOrderFrom(OrderDO from) {
        return new Order(new OrderId(from.getId()), new SerialNumber(from.getSerialNumber()));
    }

    static OrderDO toOrderDOFrom(Order from) {
        OrderDO orderDO = new OrderDO();
        orderDO.setId(from.getOrderId().getValue());
        orderDO.setSerialNumber(from.getSerialNumber().getValue());
        return orderDO;
    }
}
