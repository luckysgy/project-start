package com.projectstart.api.domain.model.user;

import lombok.Getter;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:05
 */
@Getter
public class Password {
    private final String value;

    public Password(String value) {
        this.value = value;
    }
}
