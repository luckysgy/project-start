package com.projectstart.stock.interfaces;

import com.concise.component.core.entity.response.SingleResponse;
import com.projectstart.api.application.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenguangyang
 * @date 2021-12-26 17:45
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/count/{goodsId}")
    public SingleResponse<Integer> getCount(@PathVariable(value = "goodsId") Long goodsId) {
        return SingleResponse.buildSuccess(stockService.getCountByGoodsId(goodsId + ""));
    }
}
