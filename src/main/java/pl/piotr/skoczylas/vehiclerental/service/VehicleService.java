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
import pl.piotr.skoczylas.vehiclerental.repository.BorrowerRepository;
import pl.piotr.skoczylas.vehiclerental.repository.VehicleRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class VehicleService {
    @Autowired
    private final VehicleRepository vehicleRepository;

    @Autowired
    private final BorrowerRepository borrowerRepository;

    @Autowired
    private final BorrowRepository borrowRepository;

    public VehicleService(VehicleRepository vehicleRepository, BorrowerRepository borrowerRepository,
                          BorrowRepository borrowRepository) {
        this.vehicleRepository = vehicleRepository;
        this.borrowerRepository = borrowerRepository;
        this.borrowRepository = borrowRepository;
    }

    public VehicleDto getVehicle(Long id) {
        Vehicle vehicle = getVehicleOrException(id);
        return VehicleAsm.getVehicleDto(vehicle);
    }

    public List<VehicleDto> getAllVehicles() {
        return VehicleAsm.getAllVehiclesDto(vehicleRepository.findAll());
    }

    public List<VehicleBorrowDto> getVehicleWithBorrowForGivenDay(LocalDate localDate) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleBorrowDto> vehicleBorrowDtos = new ArrayList<>();
        for (Vehicle v: vehicles) {
            vehicleBorrowDtos.add(VehicleAsm.makeVehiclesBorrowDto(v,
                    borrowRepository.findByVehicleAndDate(v, localDate)));
        }
        return vehicleBorrowDtos;
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
