package com.felece.ticketapplication.service;

import com.felece.ticketapplication.core.constant.Constant;
import com.felece.ticketapplication.core.exception.CityNotFoundException;
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
        City city = new City(createCityRequest.getCityName());

        return cityRepository.save(city);
    }

    protected City findCityById(int id){
        return cityRepository.findById(id).orElseThrow(()-> new CityNotFoundException(Constant.CITY_NOT_FOUND));
    }

}
