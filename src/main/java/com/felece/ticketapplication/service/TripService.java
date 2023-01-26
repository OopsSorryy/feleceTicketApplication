package com.felece.ticketapplication.service;


import com.felece.ticketapplication.core.constant.Constant;
import com.felece.ticketapplication.core.exception.RouteNotFoundException;
import com.felece.ticketapplication.core.exception.TripNotFoundException;
import com.felece.ticketapplication.model.Route;
import com.felece.ticketapplication.model.Trip;
import com.felece.ticketapplication.model.Vehicle;
import com.felece.ticketapplication.model.converter.TripConverter;
import com.felece.ticketapplication.model.request.CreateTripRequest;
import com.felece.ticketapplication.model.response.TripResponse;
import com.felece.ticketapplication.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final RouteService routeService;
    private final TripConverter tripConverter;

    private final VehicleService vehicleService;

    public TripResponse createTrip(CreateTripRequest createTripRequest){
        Route route = routeService.findRouteById(createTripRequest.getRouteId());
        Vehicle vehicle = vehicleService.findVehicleById(createTripRequest.getVehicleId());

        Trip trip = new Trip
                (
                        createTripRequest.getDepartureDate(),
                        createTripRequest.getDepartureTime(),
                        createTripRequest.getPrice(),
                        route,
                        vehicle
                );

        return tripConverter.convert(tripRepository.save(trip));
    }

    public List<TripResponse> getAllTrips(){
        return tripConverter.convert(tripRepository.findAll());
    }

    public List<TripResponse> findTripByRoute_FromCityIdAndRoute_ToCityIdAndDepartureDate
            (
                    int fromCityId, int toCityId, String departureDate
            ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(departureDate, formatter);


        return tripConverter.convert(
                tripRepository.findTripByRoute_FromCity_CityIdAndRoute_ToCity_CityIdAndDepartureDate
                        (fromCityId, toCityId,  localDate)
        );
    }
    protected Trip findTripById(int id){
        return tripRepository.findById(id).orElseThrow(()-> new TripNotFoundException(Constant.TRIP_NOT_FOUND));
    }
}
