package com.felece.ticketapplication.model.converter;


import com.felece.ticketapplication.model.Route;
import com.felece.ticketapplication.model.response.RouteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RouteResponseConverter {

    private final VehicleResponseConverter vehicleResponseConverter;

    public RouteResponse convert(Route from){
        return new RouteResponse
                (
                        from.getRouteId(),
                        from.getDateTime(),
                        vehicleResponseConverter.convert(from.getVehicle()),
                        from.getFromCity(),
                        from.getToCity()

                );
    }
}
