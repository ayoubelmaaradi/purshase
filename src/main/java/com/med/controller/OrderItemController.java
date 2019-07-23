package com.med.controller;

import com.med.model.OrderTo;
import com.med.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import java.util.List;

@RestController
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;


    @PostMapping("/orderItem")
    public OrderTo createOrder(@RequestBody OrderTo order) {
        return orderItemService.saveOrderItems(order);
    }
}
