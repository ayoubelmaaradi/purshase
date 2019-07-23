package com.med.service;

import com.med.model.OrderTo;
import com.med.repository.OrderRepository;
import com.med.service.inter.OrderServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServiceInter {


    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemService orderItemService;

    @Override
    public OrderTo saveOrderWithOrderItems(OrderTo order) {
        orderRepository.save(order);
        if (order.getOrderItems() != null && !order.getOrderItems().isEmpty())
            orderItemService.saveOrderItems(order);
        return order;
    }

    public OrderItemService getOrderItemService() {
        return orderItemService;
    }

    public void setOrderItemService(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }


    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
