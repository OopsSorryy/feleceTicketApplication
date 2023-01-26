package com.felece.ticketapplication.model.converter;


import com.felece.ticketapplication.model.City;
import com.felece.ticketapplication.model.Vehicle;
import com.felece.ticketapplication.model.response.CityResponse;
import com.felece.ticketapplication.model.response.VehicleResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityConverter {

    public CityResponse convert(City from){
        return new CityResponse
                (
                        from.getCityId(),
                       from.getCityName()
                );
    }

    public List<CityResponse> convert(List<City> fromList){
        return fromList.stream().map(city -> new CityResponse(
                city.getCityId(),
                city.getCityName()
        )).collect(Collectors.toList());
    }
}
