package com.felece.ticketapplication.service;


import com.felece.ticketapplication.core.constant.Constant;
import com.felece.ticketapplication.core.exception.RouteNotFoundException;
import com.felece.ticketapplication.model.City;
import com.felece.ticketapplication.model.Route;
import com.felece.ticketapplication.model.Vehicle;
import com.felece.ticketapplication.model.converter.RouteConverter;
import com.felece.ticketapplication.model.request.CreateRouteRequest;
import com.felece.ticketapplication.model.request.UpdateRouteRequest;
import com.felece.ticketapplication.model.response.RouteResponse;

import com.felece.ticketapplication.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    private final CityService cityService;


    private final RouteConverter routeConverter;

    public RouteResponse createRoute(CreateRouteRequest createRouteRequest){
        City fromCity = cityService.findCityById(createRouteRequest.getFromCityId());
        City toCity = cityService.findCityById(createRouteRequest.getToCityId());

        Route route = new Route
                (
                        fromCity,
                        toCity
                );
        return routeConverter.convert(routeRepository.save(route));
    }
    public void deleteRouteByRouteId(int id){
        routeRepository.deleteById(findRouteById(id).getRouteId());
    }

    public RouteResponse updateRoute(UpdateRouteRequest updateRouteRequest){
        Route route = findRouteById(updateRouteRequest.getRouteId());
        City fromCity = cityService.findCityById(updateRouteRequest.getFromCityId());
        City toCity = cityService.findCityById(updateRouteRequest.getToCityId());

        route.setFromCity(fromCity);
        route.setToCity(toCity);

        return routeConverter.convert(routeRepository.save(route));
    }

    public List<RouteResponse> getAll(){

        return routeConverter.convert(routeRepository.findAll());
    }

    protected Route findRouteById(int id){
        return routeRepository.findById(id).orElseThrow(()-> new RouteNotFoundException(Constant.ROUTE_NOT_FOUND));
    }
}
