package com.projectstart.api.domain.model.order;

import com.projectstart.api.domain.model.order.entity.Order;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:26
 */
public interface OrderRepository {
    /**
     * 通过id查询
     * @param orderId
     * @return
     */
    default Order find(OrderId orderId) {return null;}

    /**
     * 通过流水号查询
     * @param serialNumber
     * @return
     */
    default Order find(SerialNumber serialNumber) {return null;}

    default int store(Order order) {return 0;}

    default int delete(OrderId orderId) {return 0;}
}
