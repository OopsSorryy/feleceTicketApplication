package com.felece.ticketapplication.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRouteRequest {

    @NotNull
    private int routeId;

    @NotNull
    private int fromCityId;
    @NotNull
    private int toCityId;
}
