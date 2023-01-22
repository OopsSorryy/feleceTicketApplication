package com.felece.ticketapplication.repository;


import com.felece.ticketapplication.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}
