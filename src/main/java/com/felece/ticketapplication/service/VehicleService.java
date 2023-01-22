package com.felece.ticketapplication.service;


import com.felece.ticketapplication.core.constant.Constant;
import com.felece.ticketapplication.core.exception.VehicleNotFoundException;
import com.felece.ticketapplication.model.Vehicle;
import com.felece.ticketapplication.model.converter.VehicleResponseConverter;
import com.felece.ticketapplication.model.request.CreateVehicleRequest;
import com.felece.ticketapplication.model.request.UpdateVehicleRequest;
import com.felece.ticketapplication.model.response.VehicleResponse;
import com.felece.ticketapplication.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    private final VehicleResponseConverter vehicleResponseConverter;

    public VehicleResponse createVehicle(CreateVehicleRequest createVehicleRequest){
        Vehicle vehicle = new Vehicle(createVehicleRequest.getCapacity());

        return vehicleResponseConverter.convert(vehicleRepository.save(vehicle));
    }

    public void deleteVehicleByVehicleId(int id){
        vehicleRepository.deleteById(findVehicleById(id).getId());
    }

    public VehicleResponse updateVehicle(UpdateVehicleRequest updateVehicleRequest){
        Vehicle vehicle = findVehicleById(updateVehicleRequest.getId());

        vehicle.setCapacity(updateVehicleRequest.getCapacity());

        return vehicleResponseConverter.convert(vehicleRepository.save(vehicle));
    }

    protected Vehicle findVehicleById(int id){
        return vehicleRepository.findById(id).orElseThrow(()-> new VehicleNotFoundException(Constant.VEHICLE_NOT_FOUND));
    }
}
