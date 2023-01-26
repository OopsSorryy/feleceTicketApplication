package com.felece.ticketapplication.repository;


import com.felece.ticketapplication.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Integer> {

    List<Trip> findTripByRoute_FromCity_CityIdAndRoute_ToCity_CityIdAndDepartureDate
            (
                    int FromCityId, int ToCityId, LocalDate departureDate
            );
}
