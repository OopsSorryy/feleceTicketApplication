package com.felece.ticketapplication.service;

import com.felece.ticketapplication.core.constant.Constant;
import com.felece.ticketapplication.core.exception.CityNotFoundException;
import com.felece.ticketapplication.model.City;
import com.felece.ticketapplication.model.converter.CityConverter;
import com.felece.ticketapplication.model.request.CreateCityRequest;
import com.felece.ticketapplication.model.response.CityResponse;
import com.felece.ticketapplication.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityConverter cityConverter;

    public CityResponse createCity(CreateCityRequest createCityRequest){
        City city = new City(createCityRequest.getCityName());

        return cityConverter.convert(cityRepository.save(city));
    }

    public List<CityResponse> getAll(){

        return cityConverter.convert(cityRepository.findAll());
    }

    protected City findCityById(int id){
        return cityRepository.findById(id).orElseThrow(()-> new CityNotFoundException(Constant.CITY_NOT_FOUND));
    }

}
