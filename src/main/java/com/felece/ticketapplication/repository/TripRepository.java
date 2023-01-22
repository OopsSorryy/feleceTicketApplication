package com.felece.ticketapplication.repository;


import com.felece.ticketapplication.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip,Integer> {
}
