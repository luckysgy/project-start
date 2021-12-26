package com.projectstart.api.domain.model.goods.entity;

import com.projectstart.api.domain.model.goods.GoodsId;
import lombok.Getter;

/**
 * @author shenguangyang
 * @date 2021-12-26 18:28
 */
@Getter
public class Goods {
    private GoodsId id;

    public Goods(GoodsId id) {
        this.id = id;
    }
}
