package com.felece.ticketapplication.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BuyTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Enumerated(EnumType.STRING)
    private Statue statue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn
    private Trip trip;
}
