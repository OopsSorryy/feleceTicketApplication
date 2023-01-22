package com.felece.ticketapplication.service;


import com.felece.ticketapplication.model.request.CreateRouteRequest;
import com.felece.ticketapplication.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    private final CityService cityService;

    private final VehicleService vehicleService;

    private final RouteResponseConverter routeResponseConverter;

    public RouteResponse createRoute(CreateRouteRequest createRouteRequest){

    }
}
