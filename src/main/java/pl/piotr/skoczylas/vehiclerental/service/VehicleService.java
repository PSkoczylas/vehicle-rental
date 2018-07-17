package pl.piotr.skoczylas.vehiclerental.service;


import org.springframework.stereotype.Service;
import pl.piotr.skoczylas.vehiclerental.repository.VehicleRepository;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;


    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
}
