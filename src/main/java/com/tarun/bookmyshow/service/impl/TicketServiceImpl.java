package com.tarun.bookmyshow.service.impl;

import com.tarun.bookmyshow.models.Ticket;
import com.tarun.bookmyshow.repository.TicketRepo;
import com.tarun.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public Ticket bookTicket(List<Integer> showSeatIds, Integer userId) {
        return null;
    }
}
