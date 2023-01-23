package com.felece.ticketapplication.service;


import com.felece.ticketapplication.core.constant.Constant;
import com.felece.ticketapplication.core.exception.RouteNotFoundException;
import com.felece.ticketapplication.core.exception.VehicleNotFoundException;
import com.felece.ticketapplication.model.City;
import com.felece.ticketapplication.model.Route;
import com.felece.ticketapplication.model.Vehicle;
import com.felece.ticketapplication.model.converter.RouteResponseConverter;
import com.felece.ticketapplication.model.request.CreateRouteRequest;
import com.felece.ticketapplication.model.request.UpdateRouteRequest;
import com.felece.ticketapplication.model.request.UpdateVehicleRequest;
import com.felece.ticketapplication.model.response.RouteResponse;
import com.felece.ticketapplication.model.response.VehicleResponse;
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
        Vehicle vehicle = vehicleService.findVehicleById(createRouteRequest.getVehicleId());
        City fromCity = cityService.findCityById(createRouteRequest.getFromCityId());
        City toCity = cityService.findCityById(createRouteRequest.getToCityId());

        Route route = new Route
                (
                        createRouteRequest.getDateTime(),
                        vehicle,
                        fromCity,
                        toCity
                );
        return routeResponseConverter.convert(routeRepository.save(route));
    }
    public void deleteRouteByRouteId(int id){
        routeRepository.deleteById(findRouteById(id).getRouteId());
    }

    public RouteResponse updateRoute(UpdateRouteRequest updateRouteRequest){
        Route route = findRouteById(updateRouteRequest.getRouteId());
        Vehicle vehicle = vehicleService.findVehicleById(updateRouteRequest.getVehicleId());
        City fromCity = cityService.findCityById(updateRouteRequest.getFromCityId());
        City toCity = cityService.findCityById(updateRouteRequest.getToCityId());

        route.setDateTime(updateRouteRequest.getDateTime());
        route.setVehicle(vehicle);
        route.setFromCity(fromCity);
        route.setToCity(toCity);

        return routeResponseConverter.convert(routeRepository.save(route));
    }
    protected Route findRouteById(int id){
        return routeRepository.findById(id).orElseThrow(()-> new RouteNotFoundException(Constant.ROUTE_NOT_FOUND));
    }
}
