package com.tarun.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Ticket extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<ShowSeat> seatList;

    private double price;
}
