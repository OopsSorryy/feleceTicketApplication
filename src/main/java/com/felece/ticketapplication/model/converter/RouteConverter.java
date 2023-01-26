package com.felece.ticketapplication.model.converter;


import com.felece.ticketapplication.model.Route;
import com.felece.ticketapplication.model.response.RouteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RouteConverter {


    private final CityConverter cityConverter;

    public RouteResponse convert(Route from){
        return new RouteResponse
                (
                        from.getRouteId(),
                       cityConverter.convert( from.getFromCity()),
                        cityConverter.convert( from.getToCity())

                );
    }

    public List<RouteResponse> convert(List<Route> fromList){
        return fromList.stream().map(route -> new RouteResponse(
                route.getRouteId(),
                cityConverter.convert( route.getFromCity()),
                cityConverter.convert( route.getToCity())
        )).collect(Collectors.toList());
    }
}
