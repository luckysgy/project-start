package com.projectstart.order.interfaces;

import com.concise.component.core.entity.response.Response;
import com.projectstart.api.application.OrderService;
import com.projectstart.api.application.command.OrderCreateCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenguangyang
 * @date 2021-12-26 17:37
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create/order")
    public Response createOrder(@RequestBody OrderCreateCommand command) {
        orderService.createOrder(command);
        return Response.buildSuccess("下单成功");
    }
}
