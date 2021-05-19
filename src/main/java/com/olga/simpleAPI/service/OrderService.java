package com.olga.simpleAPI.service;

import com.olga.simpleAPI.domain.Message;
import com.olga.simpleAPI.domain.Order;
import com.olga.simpleAPI.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrders() {
        return orderRepository.findAllByOrderById();
    }

    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }

    public Long createOrderAndReturnOrderId(Order order) {
        return orderRepository.save(order).getId();
    }

    public ResponseEntity<Message> updateOrderNameAndPrice(Order order) {
        if (orderRepository.findOrderById(order.getId()) == null) {
            return new ResponseEntity<>(new Message("No such order by this ID."), HttpStatus.NOT_FOUND);
        } else {
            orderRepository.updateOrderNameAndPriceById(order.getId(), order.getName(), order.getPrice());
            return new ResponseEntity<>(new Message("Order was updated."), HttpStatus.OK);
        }
    }

    public ResponseEntity<Message> deleteOrderById(Long id) {
        if (orderRepository.findOrderById(id) == null) {
            return new ResponseEntity<>(new Message("No such order by this ID."), HttpStatus.NOT_FOUND);
        } else {
            orderRepository.deleteOrderById(id);
            return new ResponseEntity<>(new Message("Order was deleted."), HttpStatus.OK);
        }
    }
}
