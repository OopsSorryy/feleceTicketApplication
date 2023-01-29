package com.felece.ticketapplication.controller;


import com.felece.ticketapplication.model.request.CreateRouteRequest;
import com.felece.ticketapplication.model.request.UpdateRouteRequest;
import com.felece.ticketapplication.model.response.RouteResponse;
import com.felece.ticketapplication.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/route")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RouteResponse> createRoute(@RequestBody @Valid CreateRouteRequest createRouteRequest){
        return new ResponseEntity<>(routeService.createRoute(createRouteRequest), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping
    public ResponseEntity<Void> deleteRouteByRouteId(@RequestParam("routeId") int routeId){
        routeService.deleteRouteByRouteId(routeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<RouteResponse> updateRoute(@RequestBody @Valid  UpdateRouteRequest updateRouteRequest){
        return new ResponseEntity<>(routeService.updateRoute(updateRouteRequest),HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<RouteResponse>> getAllRoutes(){
        return new ResponseEntity<>(routeService.getAll(),HttpStatus.OK);
    }

}
