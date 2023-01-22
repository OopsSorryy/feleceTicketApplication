package com.felece.ticketapplication.repository;


import com.felece.ticketapplication.model.BuyTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyTicketRepository extends JpaRepository<BuyTicket,Integer> {
}
