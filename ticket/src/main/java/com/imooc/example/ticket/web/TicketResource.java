package com.imooc.example.ticket.web;

import com.imooc.example.ticket.dao.TicketRepository;
import com.imooc.example.ticket.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/ticket")
public class TicketResource {

    @Autowired
    private TicketRepository ticketRepository;

    @PostConstruct
    public void init() {
        Ticket ticket = new Ticket();
        ticket.setName("Num.1");
        ticket.setTicketNum(100L);
        ticketRepository.save(ticket);
    }
}
