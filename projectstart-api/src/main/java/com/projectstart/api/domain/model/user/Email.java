package com.projectstart.api.domain.model.user;

import com.concise.component.core.exception.BizException;
import com.concise.component.core.utils.StringUtils;
import lombok.Getter;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:04
 */
@Getter
public class Email {
    private final String value;

    public Email(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new BizException("email == null");
        }
        this.value = value;
    }
}
