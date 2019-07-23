package com.med.service.inter;

import com.med.model.OrderTo;

public interface OrderItemServiceInter {
    public OrderTo saveOrderItems(OrderTo order);

    OrderTo saveOrderWithOrderItems(OrderTo order);
}
