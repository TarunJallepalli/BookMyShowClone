package com.tarun.bookmyshow.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class City extends BaseModel{

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private List<Theatre> theatres;
}
