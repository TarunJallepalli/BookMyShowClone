package com.tarun.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Movie extends BaseModel{

    private String name;

    private String genre;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> shows;

    @ElementCollection
    @Enumerated(value = EnumType.ORDINAL)
    private List<Feature> features;
}
