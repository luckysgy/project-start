package com.projectstart.api.infrastructure.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author shenguangyang
 * @date 2021-12-26 15:17
 */
@Data
@TableName("order")
public class OrderDO {
    private Long id;
    private String serialNumber;
}
