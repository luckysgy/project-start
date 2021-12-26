package com.projectstart.api.domain.model.goods;

import com.concise.component.core.exception.BizException;
import com.concise.component.core.utils.StringUtils;
import lombok.Getter;

/**
 * @author shenguangyang
 * @date 2021-12-26 18:27
 */
@Getter
public class GoodsId {
    private final Long goodsId;

    public GoodsId(Long goodsId) {
        if (goodsId == null) {
            throw new BizException("商品id为空");
        }
        this.goodsId = goodsId;
    }
}
