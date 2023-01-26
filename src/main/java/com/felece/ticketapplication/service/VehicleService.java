package com.felece.ticketapplication.service;
import com.felece.ticketapplication.core.constant.Constant;
import com.felece.ticketapplication.core.exception.VehicleNotFoundException;
import com.felece.ticketapplication.model.Vehicle;
import com.felece.ticketapplication.model.converter.VehicleConverter;
import com.felece.ticketapplication.model.request.CreateVehicleRequest;
import com.felece.ticketapplication.model.response.VehicleResponse;
import com.felece.ticketapplication.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    private final VehicleConverter vehicleConverter;

    public VehicleResponse createVehicle(CreateVehicleRequest createVehicleRequest){
        Vehicle vehicle = new Vehicle(createVehicleRequest.getCapacity());

        return vehicleConverter.convert(vehicleRepository.save(vehicle));
    }

    public void deleteVehicleByVehicleId(int id){
        vehicleRepository.deleteById(findVehicleById(id).getVehicleId());
    }

    public VehicleResponse updateVehicle(int id,int capacity){
        Vehicle vehicle = findVehicleById(id);
        vehicle.setCapacity(capacity);

        return vehicleConverter.convert(vehicleRepository.save(vehicle));
    }

    protected Vehicle findVehicleById(int id){
        return vehicleRepository.findById(id).orElseThrow(()-> new VehicleNotFoundException(Constant.VEHICLE_NOT_FOUND));
    }

    public List<VehicleResponse> getAllVehicle(){

        return vehicleConverter.convert(vehicleRepository.findAll());
    }


}
