package com.felece.ticketapplication.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRouteRequest {

    private int routeId;

    private LocalDateTime dateTime;

    private int vehicleId;

    private int fromCityId;

    private int toCityId;
}
