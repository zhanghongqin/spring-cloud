package com.imooc.order.dao;

import com.imooc.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mavlarn on 2018/1/20.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOneByCustomerId(Long customerId);

    Order findOnByUuid(String uuid);
}
