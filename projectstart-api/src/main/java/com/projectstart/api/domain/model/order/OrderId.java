package com.projectstart.api.domain.model.order;

import com.concise.component.core.exception.BizException;
import lombok.Getter;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:26
 */
@Getter
public class OrderId {
    private final Long value;

    public OrderId(Long value) {
        if (value == null) {
            throw new BizException("orderId == null");
        }
        this.value = value;
    }
}
