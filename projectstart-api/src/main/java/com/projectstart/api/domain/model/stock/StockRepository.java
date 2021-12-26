package com.projectstart.api.domain.model.stock;

import com.projectstart.api.domain.model.goods.GoodsId;
import com.projectstart.api.domain.model.goods.entity.Goods;

/**
 * @author shenguangyang
 * @date 2021-12-26 18:31
 */
public interface StockRepository {
    default Integer getCount(GoodsId goodsId) {return 0;}
}
