package com.felece.ticketapplication.controller;


import com.felece.ticketapplication.model.City;
import com.felece.ticketapplication.model.request.CreateCityRequest;
import com.felece.ticketapplication.model.response.CityResponse;
import com.felece.ticketapplication.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<CityResponse> createCity(@RequestBody @Valid CreateCityRequest createCityRequest){
        return new ResponseEntity<>(cityService.createCity(createCityRequest),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CityResponse>> getAll(){
        return new ResponseEntity<>(cityService.getAll(), HttpStatus.OK);
    }
}
