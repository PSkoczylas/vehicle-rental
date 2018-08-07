package pl.piotr.skoczylas.vehiclerental.asm;

import pl.piotr.skoczylas.vehiclerental.dto.BorrowDto;
import pl.piotr.skoczylas.vehiclerental.dto.VehicleBorrowDto;
import pl.piotr.skoczylas.vehiclerental.dto.VehicleDto;
import pl.piotr.skoczylas.vehiclerental.model.Borrow;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;

import java.util.List;
import java.util.Optional;
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

    public static VehicleBorrowDto makeVehiclesBorrowDto(Vehicle vehicle, Borrow borrow) {
        VehicleBorrowDto vehicleBorrowDto = VehicleBorrowDto.builder()
                .vehicleType(vehicle.getDType())
                .id(vehicle.getId())
                .isBorrowed(false)
                .vehicle(VehicleAsm.getVehicleDto(vehicle))
                .build();
        if (borrow != null) {
            vehicleBorrowDto.setBorrower(BorrowerAsm.getBorrowerDto(borrow.getBorrower()));
            vehicleBorrowDto.setIsBorrowed(true);
            vehicleBorrowDto.setBorrow(BorrowAsm.getBorrowDto(borrow));
        }

        return vehicleBorrowDto;
    }
}
