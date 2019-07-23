package com.med.service;

import com.med.model.OrderItem;
import com.med.model.OrderTo;
import com.med.repository.OrderItemRepository;
import com.med.service.inter.OrderItemServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService implements OrderItemServiceInter {

@Autowired
private OrderItemRepository  orderItemRepository;


    @Override
    public OrderTo saveOrderItems(OrderTo order) {
        if (order.getOrderItems() == null ||order.getOrderItems().isEmpty()) {
            return null;
        } else {
            for (OrderItem o: order.getOrderItems()) {
               o.setOrder(order);
                orderItemRepository.save(o);
            }
        }
        return order;

    }

    @Override
    public OrderTo saveOrderWithOrderItems(OrderTo order) {
        return null;
    }

}
