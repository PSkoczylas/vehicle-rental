package pl.piotr.skoczylas.vehiclerental.asm;

import org.springframework.beans.factory.annotation.Autowired;
import pl.piotr.skoczylas.vehiclerental.dto.VehicleDto;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;
import pl.piotr.skoczylas.vehiclerental.repository.VehicleRepository;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleAsm {

    public static List<VehicleDto> getAllVehiclesDto(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(VehicleAsm::getVehicleDto)
                .collect(Collectors.toList());
    }

    public static VehicleDto getVehicleDto(Vehicle vehicle) {
        return VehicleDto.builder()
                .id(vehicle.getId())
                .vehicleType(vehicle.getDType())
                .build();
    }
}
