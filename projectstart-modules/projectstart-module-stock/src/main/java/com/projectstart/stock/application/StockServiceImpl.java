package com.projectstart.stock.application;

import cn.hutool.core.util.RandomUtil;
import com.projectstart.api.application.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author shenguangyang
 * @date 2021-12-26 17:50
 */
@Service
public class StockServiceImpl implements StockService {
    private static final Logger log = LoggerFactory.getLogger(StockServiceImpl.class);
    @Override
    public Integer getCountByGoodsId(String goodsId) {
        int count = RandomUtil.randomInt(20);
        log.info("获取商品 {} 数量 {}", goodsId, count);
        return count;
    }
}
