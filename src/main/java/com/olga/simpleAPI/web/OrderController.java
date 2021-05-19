package com.olga.simpleAPI.web;

import com.olga.simpleAPI.domain.Message;
import com.olga.simpleAPI.domain.Order;
import com.olga.simpleAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    @ResponseBody
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.findAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/order")
    @ResponseBody
    public ResponseEntity<Order> getOrder(@RequestParam Long id){
        Order order = orderService.findOrderById(id);
        return order != null ? new ResponseEntity<>(order, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/order")
    @ResponseBody
    public ResponseEntity<Long> createOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.createOrderAndReturnOrderId(order), HttpStatus.OK);
    }

    @PutMapping("/order")
    public  ResponseEntity<Message> updateOrder(@RequestBody Order order) {
        return orderService.updateOrderNameAndPrice(order);
    }

    @DeleteMapping("/order")
    public  ResponseEntity<Message> deleteOrder(@RequestParam Long id) {
        return orderService.deleteOrderById(id);
    }
}
