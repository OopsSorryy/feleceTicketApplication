package com.felece.ticketapplication.controller;


import com.felece.ticketapplication.model.Vehicle;
import com.felece.ticketapplication.model.request.CreateVehicleRequest;
import com.felece.ticketapplication.model.response.VehicleResponse;
import com.felece.ticketapplication.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<VehicleResponse> createVehicle(@RequestBody @Valid CreateVehicleRequest createVehicleRequest){
        return new ResponseEntity<>(vehicleService.createVehicle(createVehicleRequest), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getAllVehicle(){
        return new ResponseEntity<>(vehicleService.getAllVehicle(),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping
    public ResponseEntity<Void> deleteVehicleByVehicleId(@RequestParam("vehicleId") int vehicleId){
        vehicleService.deleteVehicleByVehicleId(vehicleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleResponse> updateVehicle(@PathVariable int vehicleId, @RequestParam("capacity") int capacity){
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicleId,capacity),HttpStatus.CREATED);
    }

}
