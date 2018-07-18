package pl.piotr.skoczylas.vehiclerental.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piotr.skoczylas.vehiclerental.repository.VehicleRepository;


@Service
public class VehicleService {
    @Autowired
    private final VehicleRepository vehicleRepository;


    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

}
