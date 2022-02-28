package com.projectstart.order.infrastructure.persistence.repository;

import com.projectstart.api.domain.model.order.OrderRepository;
import com.projectstart.api.domain.model.order.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author shenguangyang
 * @date 2021-12-26 18:42
 */
@Service
public class OrderRepositoryImpl implements OrderRepository {
    private static final Logger log = LoggerFactory.getLogger(OrderRepositoryImpl.class);
    @Override
    public int store(Order order) {
        log.info("订单创建成功.....");
        return OrderRepository.super.store(order);
    }
}
