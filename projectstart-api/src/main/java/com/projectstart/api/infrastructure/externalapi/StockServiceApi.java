package com.projectstart.api.infrastructure.externalapi;

import com.concise.component.core.entity.response.SingleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 库存服务接口
 * @author shenguangyang
 * @date 2021-12-26 15:58
 */
@FeignClient(name = "provider", url = "http://127.0.0.1:9095/stock")
public interface StockServiceApi {
    @RequestMapping("/count/{goodsId}")
    SingleResponse<Integer> getCountByGoodsId(@PathVariable("goodsId") Long goodsId);
}
