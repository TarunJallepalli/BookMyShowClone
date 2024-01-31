package com.tarun.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel{

    private String name;

    @Enumerated(value = EnumType.ORDINAL)
    private SeatType seatType;

    private int topLeftX;

    private int topLeftY;

    private int bottomRightX;

    private int bottomRightY;
}
