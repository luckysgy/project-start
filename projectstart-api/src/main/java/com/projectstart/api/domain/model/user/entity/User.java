package com.projectstart.api.domain.model.user.entity;

import com.concise.component.core.exception.BizException;
import com.projectstart.api.domain.model.user.*;
import lombok.Getter;
import lombok.ToString;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:01
 */
@Getter
@ToString
public class User {
    private final UserId id;
    private final Phone phone;
    private final Email email;
    private final Username username;
    private Password password;

    public User(UserId id, Phone phone, Email email, Username username, Password password) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     * 密码是否正确
     *
     * @param passwordStr
     * @return
     */
    public boolean checkPassword(String passwordStr) {
        return password != null && this.password.sameValueAs(Password.create(passwordStr, this.password.getSalt()));
    }

    /**
     * 修改密码
     *
     * @param oldPasswordStr
     * @param newPasswordStr
     * @return
     */
    public void changePassword(String oldPasswordStr,String newPasswordStr) {
        if(!checkPassword(oldPasswordStr)) {
            throw new BizException("原密码不正确");
        }
        this.password = Password.create(newPasswordStr, password.getSalt());
    }
}
