package com.tarun.bookmyshow.repository;

import com.tarun.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

}
