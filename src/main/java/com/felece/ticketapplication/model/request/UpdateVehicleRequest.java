package com.felece.ticketapplication.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVehicleRequest {

    @NotNull
    private int id;

    @NotNull
    private int capacity;
}
