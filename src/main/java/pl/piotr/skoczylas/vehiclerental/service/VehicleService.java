package pl.piotr.skoczylas.vehiclerental.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piotr.skoczylas.vehiclerental.asm.VehicleAsm;
import pl.piotr.skoczylas.vehiclerental.dto.BorrowDto;
import pl.piotr.skoczylas.vehiclerental.dto.VehicleDto;
import pl.piotr.skoczylas.vehiclerental.dto.VehicleWithBorrowDto;
import pl.piotr.skoczylas.vehiclerental.exception.NotFoundException;
import pl.piotr.skoczylas.vehiclerental.model.Borrower;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;
import pl.piotr.skoczylas.vehiclerental.repository.BorrowerRepository;
import pl.piotr.skoczylas.vehiclerental.repository.VehicleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class VehicleService {
    @Autowired
    private final VehicleRepository vehicleRepository;

    @Autowired
    private final BorrowerRepository borrowerRepository;

    public VehicleService(VehicleRepository vehicleRepository, BorrowerRepository borrowerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.borrowerRepository = borrowerRepository;
    }

    public VehicleDto getVehicle(Long id) {
        Vehicle vehicle = getVehicleOrException(id);
        return VehicleAsm.getVehicleDto(vehicle);
    }

    public List<VehicleDto> getAllVehicles() {
        return VehicleAsm.getAllVehiclesDto(vehicleRepository.findAll());
    }

    public List<VehicleWithBorrowDto> getVehicleWithBorrowForGivenDay(LocalDate localDate) {
        // TODO
        return null;
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
