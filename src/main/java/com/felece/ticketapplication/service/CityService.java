package com.felece.ticketapplication.service;

import com.felece.ticketapplication.model.City;
import com.felece.ticketapplication.model.request.CreateCityRequest;
import com.felece.ticketapplication.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public City createCity(CreateCityRequest createCityRequest){
        City city = new City(createCityRequest.getName());

        return cityRepository.save(city);
    }

}
