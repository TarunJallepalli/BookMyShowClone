package com.tarun.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Ticket extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<ShowSeat> showSeatList;

    private Date timeOfBooking;

    private double price;

    @Override
    public String toString() {
        return "Ticket{" +
                "user=" + user +
                ", showSeatList=" + showSeatList.get(0).getSeat() +
                ", timeOfBooking=" + timeOfBooking +
                ", price=" + price +
                '}';
    }
}
