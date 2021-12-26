package com.projectstart.api.domain.specification;

import com.concise.component.core.entity.response.SingleResponse;
import com.concise.component.core.exception.BizException;
import com.concise.component.ddd.AbstractSpecification;
import com.projectstart.api.domain.model.goods.GoodsId;
import com.projectstart.api.infrastructure.externalapi.StockServiceApi;

/**
 * @author shenguangyang
 * @date 2021-12-26 18:03
 */
public class GoodsStockCountCheckSpecification extends AbstractSpecification<GoodsId> {
    private StockServiceApi stockServiceApi;

    public GoodsStockCountCheckSpecification(StockServiceApi stockServiceApi) {
        this.stockServiceApi = stockServiceApi;
    }

    @Override
    public boolean isSatisfiedBy(GoodsId goodsId) {
        SingleResponse<Integer> count = stockServiceApi.getCountByGoodsId(goodsId.getGoodsId());
        if (!count.isSuccess() || count.getData() <=0) {
            throw new BizException("商品 " + goodsId.getGoodsId() + " 库存不足");
        }
        return true;
    }
}
