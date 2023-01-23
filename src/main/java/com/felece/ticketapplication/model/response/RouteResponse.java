package com.felece.ticketapplication.model.response;


import com.felece.ticketapplication.model.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteResponse {

    private int routeId;

    private LocalDateTime dateTime;

    private VehicleResponse vehicleResponse;

    private City fromCity;

    private City toCity;

}
