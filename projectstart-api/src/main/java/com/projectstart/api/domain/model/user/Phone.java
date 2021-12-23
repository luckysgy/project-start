package com.projectstart.api.domain.model.user;

import com.concise.component.core.exception.BizException;
import com.concise.component.core.utils.StringUtils;
import lombok.Getter;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:04
 */
@Getter
public class Phone {
    private final String value;

    public Phone(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new BizException("phone == null");
        }
        this.value = value;
    }
}
