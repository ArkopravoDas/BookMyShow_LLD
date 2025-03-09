package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Venue extends BaseModel {
    private String name;
    private String city;

    @OneToMany(mappedBy = "venue")
    private List<Hall> halls;
}
