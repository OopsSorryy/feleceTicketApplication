package com.felece.ticketapplication.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;


    private LocalDate departureDate;


    private LocalTime departureTime;

    private Long price;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Vehicle vehicle;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn
    private Route route;

    public Trip(LocalDate departureDate, LocalTime departureTime, Long price, Route route, Vehicle vehicle) {
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.price = price;
        this.route = route;
        this.vehicle = vehicle;
    }
}
