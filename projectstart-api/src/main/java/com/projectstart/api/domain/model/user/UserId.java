package com.projectstart.api.domain.model.user;

import com.concise.component.core.exception.BizException;
import lombok.Getter;

/**
 * @author shenguangyang
 * @date 2021-12-26 12:42
 */
@Getter
public class UserId {
    private final Long value;

    public UserId(Long value) {
        this.value = value;
        if (value == null) {
            throw new BizException("UserId == null");
        }
    }
}
