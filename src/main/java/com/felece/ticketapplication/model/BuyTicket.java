package com.felece.ticketapplication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BuyTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyTicketId;

    private int seatNumber;

    @Enumerated(EnumType.STRING)
    private Statue statue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn
    private Trip trip;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn
    private Customer customer;

    public BuyTicket(int seatNumber, Statue statue, Trip trip, Customer customer) {
        this.seatNumber = seatNumber;
        this.statue = statue;
        this.trip = trip;
        this.customer = customer;
    }
}
