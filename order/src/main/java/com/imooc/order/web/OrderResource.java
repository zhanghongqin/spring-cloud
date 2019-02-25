package com.imooc.order.web;

import com.imooc.example.dto.IOrderService;
import com.imooc.example.dto.OrderDTO;
import com.imooc.order.dao.OrderRepository;
import com.imooc.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderResource implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("")
    public Order create(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("")
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public  OrderDTO getMyOrder(@PathVariable(name = "id") Long id) {
        Order order = orderRepository.findOne(id);
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setTitle(order.getTitle());
        return dto;

    }
}
