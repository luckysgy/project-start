package com.projectstart.api.domain.model.user.entity;

import com.projectstart.api.domain.model.user.Email;
import com.projectstart.api.domain.model.user.Password;
import com.projectstart.api.domain.model.user.Phone;
import com.projectstart.api.domain.model.user.Username;
import lombok.Getter;
import lombok.ToString;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:01
 */
@Getter
@ToString
public class User {
    private final Long id;
    private final Phone phone;
    private final Email email;
    private final Username username;
    private final Password password;

    public User(Long id, Phone phone, Email email, Username username, Password password) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
