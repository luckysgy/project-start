package com.projectstart.api.infrastructure.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.projectstart.api.domain.model.user.*;
import lombok.Data;

/**
 * @author shenguangyang
 * @date 2021-12-26 15:16
 */
@Data
@TableName("user")
public class UserDO {
    private Long id;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String salt;
}
