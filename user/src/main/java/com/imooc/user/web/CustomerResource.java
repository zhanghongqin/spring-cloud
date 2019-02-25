package com.imooc.user.web;

import com.imooc.example.dto.OrderDTO;
import com.imooc.user.dao.CustomerRepository;
import com.imooc.user.domain.Customer;
import com.imooc.user.feign.OrderClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerResource {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderClient orderClient;

    @PostConstruct
    public void init(){
        Customer me = new Customer();
        me.setUsername("imooc");
        me.setPassword("111111");
        me.setRole("USER");
        customerRepository.save(me);
    }

    @PostMapping(value = "")
    public Customer create(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("")
    @HystrixCommand
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/my")
    @HystrixCommand
    public Map getMyInfo() {
        Customer customer = customerRepository.findOneByUsername("imooc");
        OrderDTO order = orderClient.getMyOrder(1L);
        Map result = new HashMap();
        result.put("customer", customer);
        result.put("order", order);
        return result;
    }
}
