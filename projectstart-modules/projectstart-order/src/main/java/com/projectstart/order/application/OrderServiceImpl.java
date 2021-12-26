package com.projectstart.order.application;

import com.projectstart.api.application.OrderService;
import com.projectstart.api.application.command.OrderCreateCommand;
import com.projectstart.api.application.event.OrderCreateMessage;
import com.projectstart.api.domain.model.goods.GoodsId;
import com.projectstart.api.domain.model.order.OrderRepository;
import com.projectstart.api.domain.model.user.UserId;
import com.projectstart.api.domain.specification.GoodsStockCountCheckSpecification;
import com.projectstart.api.domain.specification.OrderWindControlSpecification;
import com.projectstart.api.infrastructure.externalapi.StockServiceApi;
import com.projectstart.api.infrastructure.mq.MqSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shenguangyang
 * @date 2021-12-26 17:52
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StockServiceApi stockServiceApi;

    @Autowired
    private MqSendService mqSendService;

    @Override
    public void createOrder(OrderCreateCommand command) {
        // 检查库存
        for (Long goodsId : command.getGoodsIds()) {
            GoodsStockCountCheckSpecification stockCountCheckSpec = new GoodsStockCountCheckSpecification(stockServiceApi);
            stockCountCheckSpec.isSatisfiedBy(new GoodsId(goodsId));
        }

        // 风控检查
        OrderWindControlSpecification orderWindControlSpec = new OrderWindControlSpecification();
        orderWindControlSpec.isSatisfiedBy(new UserId(1L));

        // 还有一些其他检查就不列出了

        // 创建订单并发布到消息队列中, 由消息队列进行消费
        OrderCreateMessage orderCreateMessage = new OrderCreateMessage();
        orderCreateMessage.setGoodsIds(command.getGoodsIds());
        mqSendService.send(orderCreateMessage);
    }
}
