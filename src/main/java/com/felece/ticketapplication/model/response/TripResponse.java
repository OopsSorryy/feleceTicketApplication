package com.felece.ticketapplication.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripResponse {

    private int tripId;

    private LocalDate departureDate;

    private LocalTime departureTime;

    private Long price;

    private RouteResponse routeResponse;

    private VehicleResponse vehicleResponse;

}
