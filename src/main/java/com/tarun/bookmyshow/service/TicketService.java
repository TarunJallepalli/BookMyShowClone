package com.tarun.bookmyshow.service;

import com.tarun.bookmyshow.models.Ticket;

import java.util.List;

public interface TicketService {
    public Ticket bookTicket(List<Integer> showSeatIds, Integer userId);
}
