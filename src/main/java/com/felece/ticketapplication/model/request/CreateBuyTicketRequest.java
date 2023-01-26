package com.felece.ticketapplication.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBuyTicketRequest {


    @NotNull
    @Min(1)
    private int seatNumber;

    @NotNull
    private int tripId;

    @NotNull
    private int customerId;

}
