package com.projectstart.api.domain.model.user;

import com.concise.component.core.exception.BizException;
import com.concise.component.core.utils.StringUtils;
import lombok.Getter;
import org.springframework.validation.BindException;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:05
 */
@Getter
public class Username {
    private final String value;

    public Username(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new BizException("username == null");
        }
        this.value = value;
    }
}
