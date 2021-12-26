package com.projectstart.api.domain.model.order;

import com.concise.component.core.exception.BizException;
import com.concise.component.core.utils.StringUtils;
import lombok.Getter;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:29
 */
@Getter
public class SerialNumber {
    private final String value;

    public SerialNumber(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new BizException("SerialNumber == null");
        }
        this.value = value;
    }
}
