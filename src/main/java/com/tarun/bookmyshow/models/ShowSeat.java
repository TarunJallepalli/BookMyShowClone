package com.tarun.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ShowSeat extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @OneToOne
    private User user;

    @Enumerated(value = EnumType.ORDINAL)
    private SeatStatus seatStatus;

    private double price;
}
