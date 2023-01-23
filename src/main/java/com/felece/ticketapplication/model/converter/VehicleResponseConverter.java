package com.felece.ticketapplication.model.converter;


import com.felece.ticketapplication.model.Vehicle;
import com.felece.ticketapplication.model.response.VehicleResponse;
import org.springframework.stereotype.Component;

@Component
public class VehicleResponseConverter {

    public VehicleResponse convert(Vehicle from){
        return new VehicleResponse
                (
                        from.getVehicleId(),
                        from.getCapacity()
                );
    }
}
