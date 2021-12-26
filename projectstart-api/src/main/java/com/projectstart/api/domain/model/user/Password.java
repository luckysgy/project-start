package com.projectstart.api.domain.model.user;

import com.concise.component.core.exception.BizException;
import com.concise.component.core.utils.MD5Utils;
import com.concise.component.core.utils.StringUtils;
import com.concise.component.ddd.ValueObject;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author shenguangyang
 * @date 2021-12-24 7:05
 */
@Getter
public class Password implements ValueObject<Password> {
    private final String password;
    /**
     * 盐
     */
    private String salt;

    public Password(String password, String salt) {
        if (StringUtils.isEmpty(password)) {
            throw new BizException("password不能为空");
        }
        this.password = password;
        this.salt = salt;
    }

    public static Password create(String passwordStr) {
        String salt = RandomStringUtils.randomAlphanumeric(20);
        String password = MD5Utils.md5(passwordStr + salt);
        return new Password(password, salt);
    }

    public static Password create(String passwordStr, String salt) {
        if(passwordStr.length() < 3) {
            throw new IllegalArgumentException("密码长度不能小于3");
        }
        String password = MD5Utils.md5(passwordStr + salt);
        return new Password(password, salt);
    }

    @Override
    public boolean sameValueAs(Password other) {
        return this.password != null && this.password.equals(other.getPassword());
    }
}
