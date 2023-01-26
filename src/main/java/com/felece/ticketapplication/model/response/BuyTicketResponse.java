package com.felece.ticketapplication.model.response;
import com.felece.ticketapplication.model.Statue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyTicketResponse {

    private int buyTicketId;

    private int seatNumber;

    private Statue statue;

    private TripResponse tripResponse;

    private CustomerResponse customerResponse;


}
