package com.felece.ticketapplication.repository;

import com.felece.ticketapplication.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}
