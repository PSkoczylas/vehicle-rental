package pl.piotr.skoczylas.vehiclerental.service;

import org.springframework.stereotype.Service;
import pl.piotr.skoczylas.vehiclerental.model.Manufacturer;
import pl.piotr.skoczylas.vehiclerental.repository.ManufacturerRepository;

@Service
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;


    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }


}
