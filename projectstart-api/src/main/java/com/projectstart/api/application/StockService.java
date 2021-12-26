package com.projectstart.api.application;

/**
 * @author shenguangyang
 * @date 2021-12-26 17:48
 */
public interface StockService {
    /**
     * 通过商品id获取商品数量
     * @param goodsId 商品id
     * @return
     */
    default Integer getCountByGoodsId(String goodsId) {return 0;}
}
