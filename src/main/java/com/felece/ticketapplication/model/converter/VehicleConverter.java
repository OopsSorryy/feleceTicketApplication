package com.felece.ticketapplication.model.converter;


import com.felece.ticketapplication.model.Vehicle;
import com.felece.ticketapplication.model.response.VehicleResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleConverter {

    public VehicleResponse convert(Vehicle from){
        return new VehicleResponse
                (
                        from.getVehicleId(),
                        from.getCapacity()
                );
    }

    public List<VehicleResponse> convert(List<Vehicle> fromList){
        return fromList.stream().map(vehicle -> new VehicleResponse(
                vehicle.getVehicleId(),
                vehicle.getCapacity()
        )).collect(Collectors.toList());
    }
}
