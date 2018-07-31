package pl.piotr.skoczylas.vehiclerental.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piotr.skoczylas.vehiclerental.asm.VehicleAsm;
import pl.piotr.skoczylas.vehiclerental.dto.VehicleDto;
import pl.piotr.skoczylas.vehiclerental.exception.NotFoundException;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;
import pl.piotr.skoczylas.vehiclerental.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleService {
    @Autowired
    private final VehicleRepository vehicleRepository;


    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleDto getVehicle(Long id) {
        Vehicle vehicle = getVehicleOrException(id);
        return VehicleAsm.getVehicleDto(vehicle);
    }

    public  List<VehicleDto> getAllVehicles() {
        return VehicleAsm.getAllVehiclesDto(vehicleRepository.findAll());
    }

    public void removeVehicle(Long id) {
        Vehicle vehicle = getVehicleOrException(id);
        vehicleRepository.delete(vehicle);
    }

    private Vehicle getVehicleOrException(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return  vehicle.orElseThrow(() -> new NotFoundException("Vehicle with given ID doesn't exist"));
    }

}
