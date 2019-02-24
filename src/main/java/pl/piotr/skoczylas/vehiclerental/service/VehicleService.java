package pl.piotr.skoczylas.vehiclerental.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piotr.skoczylas.vehiclerental.asm.VehicleAsm;
import pl.piotr.skoczylas.vehiclerental.dto.VehicleDto;
import pl.piotr.skoczylas.vehiclerental.dto.VehicleBorrowDto;
import pl.piotr.skoczylas.vehiclerental.exception.NotFoundException;
import pl.piotr.skoczylas.vehiclerental.model.Borrow;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;
import pl.piotr.skoczylas.vehiclerental.repository.BorrowRepository;
import pl.piotr.skoczylas.vehiclerental.repository.VehicleRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final BorrowRepository borrowRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, BorrowRepository borrowRepository) {
        this.vehicleRepository = vehicleRepository;
        this.borrowRepository = borrowRepository;
    }

    public VehicleDto getVehicle(Long id) {
        Vehicle vehicle = getVehicleOrException(id);
        return VehicleAsm.getVehicleDto(vehicle);
    }

    public List<VehicleDto> getAllVehicles() {
        return this.getAllVehiclesDto(vehicleRepository.findAll());
    }

    protected List<VehicleDto> getAllVehiclesDto(List<Vehicle> vehicles) {
        return VehicleAsm.getAllVehiclesDto(vehicles);
    }

    public List<VehicleBorrowDto> getVehicleWithBorrowForGivenDay(LocalDate localDate) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleBorrowDto> vehicleBorrowDtoList = new ArrayList<>();
        for (Vehicle v: vehicles) {
            vehicleBorrowDtoList.add(
                    makeVehicleBorrowDto(v, borrowRepository.findByVehicleAndDate(v, localDate)));
        }
        return vehicleBorrowDtoList;
    }

    protected VehicleBorrowDto makeVehicleBorrowDto(Vehicle vehicle, Borrow borrow) {
        return VehicleAsm.makeVehiclesBorrowDto(vehicle, borrow);
    }

    public void removeVehicle(Long id) {
        Vehicle vehicle = getVehicleOrException(id);
        vehicleRepository.delete(vehicle);
    }

    public Vehicle getVehicleOrException(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return  vehicle.orElseThrow(() -> new NotFoundException("Vehicle with given ID doesn't exist"));
    }

}
