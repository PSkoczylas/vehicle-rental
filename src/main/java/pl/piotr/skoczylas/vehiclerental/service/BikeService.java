package pl.piotr.skoczylas.vehiclerental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piotr.skoczylas.vehiclerental.repository.BikeRepository;

@Service
public class BikeService {
    @Autowired
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }
}
