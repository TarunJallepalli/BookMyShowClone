package com.tarun.bookmyshow.controller;

import com.tarun.bookmyshow.dtos.BookTicketRequestDto;
import com.tarun.bookmyshow.dtos.BookTicketResponseDto;
import com.tarun.bookmyshow.models.Ticket;
import com.tarun.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    private BookTicketResponseDto BookTicket(BookTicketRequestDto bookTicketRequestDto) {

        try {
            validateRequest(bookTicketRequestDto.getShowSeatIds(), bookTicketRequestDto.getUserId());
            Ticket ticket = ticketService.bookTicket(bookTicketRequestDto.getShowSeatIds(), bookTicketRequestDto.getUserId());
            return BookTicketResponseDto.getTicketSuccessMessage("Message Created Successfully", ticket);
        }
        catch (Exception e) {
            return BookTicketResponseDto.getTicketFailureMessage(e.getMessage(), null);
        }
    }

    private void validateRequest(List<Integer> showSeatIds, Integer userId) throws Exception {

        if(Objects.isNull(showSeatIds) || showSeatIds.isEmpty()) {
            throw new Exception("No Tickets Booked");
        }

        if(showSeatIds.size() > 10) {
            throw new Exception("Maximum of 10 tickets can be booked per transaction");
        }

        if(Objects.isNull(userId) || userId < 0) {
            throw new Exception("Invalid user Id");
        }
    }

}
