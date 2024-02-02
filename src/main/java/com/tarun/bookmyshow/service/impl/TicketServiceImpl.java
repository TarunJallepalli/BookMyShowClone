package com.tarun.bookmyshow.service.impl;

import com.tarun.bookmyshow.models.*;
import com.tarun.bookmyshow.repository.ShowSeatRepo;
import com.tarun.bookmyshow.repository.TicketRepo;
import com.tarun.bookmyshow.repository.UserRepo;
import com.tarun.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ShowSeatRepo showSeatRepo;


    @Override
    public Ticket bookTicket(List<Integer> showSeatIds, Integer userId) throws Exception {

        // check for valid userId
        Optional<User> userOpt = userRepo.getUserById(userId);
        if(userOpt.isEmpty()) {
            throw new Exception("Invalid UserId");
        }
        User user = userOpt.get();

        // Check if all showSeats are available
        List<ShowSeat> showSeats = getAvailableShowSeats(showSeatIds);

        // get show
        Show show = showSeats.get(0).getShow();

        // get total amount for tickets
        double totalPrice = showSeats.stream().map(ShowSeat::getPrice).reduce(Double::sum).get();

        Ticket ticket = new Ticket();
        ticket.setShowSeatList(showSeats);
        ticket.setUser(user);
        ticket.setPrice(totalPrice);
        ticket.setTimeOfBooking(new Date());
        ticketRepo.save(ticket);

        return ticket;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    protected List<ShowSeat> getAvailableShowSeats(List<Integer> showSeatIds) throws Exception {

        List<ShowSeat> showSeats = showSeatRepo.findShowSeatByIdIn(showSeatIds);
        showSeats = showSeats.stream().filter(showSeat -> showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE)).toList();
        if(showSeats.size() != showSeatIds.size()) {
            throw new Exception("The seats you were trying to book were already Booked");
        }
        showSeats.forEach(showSeat -> {
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            showSeatRepo.save(showSeat);
        });

        return showSeats;
    }
}
