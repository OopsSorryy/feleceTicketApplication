package com.felece.ticketapplication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeId;

    private LocalDateTime dateTime;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn
    private City fromCity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn
    private City toCity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "route")
    private List<Trip> trips;

    public Route(LocalDateTime dateTime, Vehicle vehicle, City fromCity, City toCity) {
        this.dateTime = dateTime;
        this.vehicle = vehicle;
        this.fromCity = fromCity;
        this.toCity = toCity;
    }
}
