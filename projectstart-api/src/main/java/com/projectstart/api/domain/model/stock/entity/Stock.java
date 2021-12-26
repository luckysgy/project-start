package com.projectstart.api.domain.model.stock.entity;

import com.concise.component.ddd.Entity;
import com.projectstart.api.domain.model.goods.GoodsId;
import lombok.Getter;

/**
 * @author shenguangyang
 * @date 2021-12-26 18:30
 */
@Getter
public class Stock implements Entity<Stock> {
    private Long id;
    /**
     * 商品id
     */
    private GoodsId goodsId;
    /**
     * 数量
     */
    private Integer count;

    public Stock(Long id, GoodsId goodsId, Integer count) {
        this.id = id;
        this.goodsId = goodsId;
        this.count = count;
    }

    @Override
    public boolean sameIdentityAs(Stock other) {
        return this.id != null && this.id.equals(other.id);
    }
}
