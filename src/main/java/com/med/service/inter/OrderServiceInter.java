package com.med.service.inter;

import com.med.model.OrderTo;


public interface OrderServiceInter {

    public OrderTo saveOrderWithOrderItems(OrderTo order);
}
