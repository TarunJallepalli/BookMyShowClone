package com.tarun.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Screen extends BaseModel{

    private String name;

    @OneToMany
    @JoinColumn(name = "screen_id")
    private List<Seat> seats;

    @ElementCollection
    @Enumerated(value = EnumType.ORDINAL)
    private List<Feature> features;
}
