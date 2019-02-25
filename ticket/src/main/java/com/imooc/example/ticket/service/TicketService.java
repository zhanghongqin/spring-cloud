package com.imooc.example.ticket.service;

import com.imooc.example.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private static final Logger LOG = LoggerFactory.getLogger(TicketService.class);

    @JmsListener(destination = "order:new", containerFactory = "msgFactory")
    public void handleTicketLock(OrderDTO dto) {
        LOG.info("Got new order for ticket lock:{}", dto);
    }

    public void ticketLock(OrderDTO dto) {

    }
}
