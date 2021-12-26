package com.projectstart.api.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.projectstart.api.infrastructure.persistence.entity.OrderDO;
import com.projectstart.api.infrastructure.persistence.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shenguangyang
 * @date 2021-12-26 15:19
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {
}
