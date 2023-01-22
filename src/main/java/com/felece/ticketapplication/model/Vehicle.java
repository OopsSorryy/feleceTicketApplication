package com.felece.ticketapplication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private int capacity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "vehicle")
    private Route route;

    public Vehicle(int capacity) {
        this.capacity = capacity;
    }


}
