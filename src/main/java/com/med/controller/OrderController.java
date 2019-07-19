package com.med.controller;

import com.med.model.Order;
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
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
    /*
      @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrderWithOrderItems(order);
    }
    * */

    @GetMapping("/order/edit/{id}")
    public Order getOneOrder(@PathVariable("id") Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.get() != null) {
            return order.get();
        }
        return null;
    }



    /*



    @PostMapping("/customer/update/{id}")
    public Order updateChambre(@PathVariable("id") Long id, Order invoice) {
        Optional<Order> orderLoaded = OrderRepository.findById(id);
        if (orderLoaded != null) {
            return OrderRepository.save(invoice);
        }

        return null;
    }

    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable("id") Long id) {
        Optional<Order> order = OrderRepository.findById(id);

        if (order != null) {
            OrderRepository.delete(order.get());
            return new ResponseEntity<Order>(HttpStatus.OK);
        }
        return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
    }

    public OrderRepository getOrderRepository() {
        return OrderRepository;
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.OrderRepository = orderRepository;
    }*/


}
