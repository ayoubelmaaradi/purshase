package com.med.service.inter;

import com.med.model.Order;

public interface OrderItemServiceInter {
    public Order saveOrderItems(Order order);

    Order saveOrderWithOrderItems(Order order);
}
