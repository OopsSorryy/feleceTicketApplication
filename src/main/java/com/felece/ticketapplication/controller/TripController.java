package com.felece.ticketapplication.controller;


import com.felece.ticketapplication.core.constant.Constant;
import com.felece.ticketapplication.core.exception.TripNotFoundException;
import com.felece.ticketapplication.model.Trip;
import com.felece.ticketapplication.model.request.CreateTripRequest;
import com.felece.ticketapplication.model.response.TripResponse;
import com.felece.ticketapplication.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trip")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TripResponse> createTrip(@RequestBody @Valid CreateTripRequest createTripRequest){
        return new ResponseEntity<>(tripService.createTrip(createTripRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TripResponse>> getAllTrips(){
        return new ResponseEntity<>(tripService.getAllTrips(),HttpStatus.OK);
    }

    @GetMapping("/{fromCityId}/{toCityId}/{departureDate}")
    public ResponseEntity<List<TripResponse>> findTripByRoute_FromCityIdAndRoute_ToCityIdAndDepartureDateAndAndDepartureTime(
           @PathVariable int fromCityId, @PathVariable int toCityId,
           @PathVariable String departureDate
    ){
        return new ResponseEntity<>(
                tripService.findTripByRoute_FromCityIdAndRoute_ToCityIdAndDepartureDate(
                        fromCityId,toCityId,departureDate
                ),HttpStatus.OK);
    }


}
