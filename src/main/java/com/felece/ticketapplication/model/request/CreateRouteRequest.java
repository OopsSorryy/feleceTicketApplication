package com.felece.ticketapplication.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRouteRequest {


    @NotNull
    private int fromCityId;

    @NotNull
    private int toCityId;
}
