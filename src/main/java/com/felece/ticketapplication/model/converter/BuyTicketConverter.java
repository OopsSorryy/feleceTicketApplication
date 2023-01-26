package com.felece.ticketapplication.model.converter;


import com.felece.ticketapplication.model.BuyTicket;
import com.felece.ticketapplication.model.Trip;
import com.felece.ticketapplication.model.response.BuyTicketResponse;
import com.felece.ticketapplication.model.response.TripResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BuyTicketConverter {

    private final TripConverter tripConverter;
    private final CustomerConverter customerConverter;

    public BuyTicketResponse convert(BuyTicket from){
        return new BuyTicketResponse(
                from.getBuyTicketId(),
                from.getSeatNumber(),
                from.getStatue(),
                tripConverter.convert(from.getTrip()),
                customerConverter.convert(from.getCustomer()));
    }

    public List<BuyTicketResponse> convert(List<BuyTicket> fromList){
        return fromList.stream().map(buy->new BuyTicketResponse(
                buy.getBuyTicketId(),
                buy.getSeatNumber(),
                buy.getStatue(),
                tripConverter.convert(buy.getTrip()),
                customerConverter.convert(buy.getCustomer())

        )).collect(Collectors.toList());
    }
}
