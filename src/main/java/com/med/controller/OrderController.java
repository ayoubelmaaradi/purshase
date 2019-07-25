package com.med.controller;

import com.med.model.OrderTo;
import com.med.repository.OrderRepository;
import com.med.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-purshase")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    public OrderService getOrderService() {
        return orderService;
    }

    @GetMapping("/orders")
    public List<OrderTo> getAll() {
        return orderRepository.findAll();
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

//    @PostMapping("/order")
//    public OrderTo createOrder(@RequestBody OrderTo order) {
//        return orderRepository.save(order);
//    }

      @PostMapping("/order")
    public OrderTo createOrder(@RequestBody OrderTo order) {
        return orderService.saveOrderWithOrderItems(order);
    }

    @GetMapping("/order/edit")
    public OrderTo updateOrder(@RequestBody OrderTo orderTo) {
        Optional<OrderTo> order = orderRepository.findById(orderTo.getId());
        if (order.get() != null) {
            return orderRepository.save(orderTo);
        }
        return null;
    }

    @GetMapping("/order/delete")
    public ResponseEntity<OrderTo> deleteOrder(@RequestBody OrderTo orderTo) {
        Optional<OrderTo> order = orderRepository.findById(orderTo.getId());
        if (order.get() != null) {
            orderRepository.delete(orderTo);
            return new ResponseEntity<OrderTo>(HttpStatus.OK);
        }
        return new ResponseEntity<OrderTo>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/order/edit/{id}")
    public OrderTo getOneOrder(@PathVariable("id") Long id, @RequestBody OrderTo orderTo) {
        Optional<OrderTo> order = orderRepository.findById(id);
        if (order.get() != null) {
            return orderRepository.save(order.get());
        }
        return null;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
