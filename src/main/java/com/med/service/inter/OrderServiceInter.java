package com.med.service.inter;
import com.med.model.Order;


public interface OrderServiceInter {

    public Order saveOrderWithOrderItems(Order order);
}
