package com.felece.ticketapplication.model.converter;

import com.felece.ticketapplication.model.Trip;
import com.felece.ticketapplication.model.response.TripResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TripConverter {

    private final RouteConverter routeConverter;

    private final VehicleConverter vehicleConverter;

    public TripResponse convert(Trip from){
        return new TripResponse
                (
                        from.getTripId(),
                        from.getDepartureDate(),
                        from.getDepartureTime(),
                        from.getPrice(),
                       routeConverter.convert(from.getRoute()),
                        vehicleConverter.convert(from.getVehicle())
                );
    }

    public List<TripResponse> convert(List<Trip> fromList){
        return fromList.stream().map(trip -> new TripResponse(
                trip.getTripId(),
                trip.getDepartureDate(),
                trip.getDepartureTime(),
                trip.getPrice(),
                routeConverter.convert(trip.getRoute()),
                vehicleConverter.convert(trip.getVehicle())
        )).collect(Collectors.toList());
    }

}
