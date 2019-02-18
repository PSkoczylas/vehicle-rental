package pl.piotr.skoczylas.vehiclerental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piotr.skoczylas.vehiclerental.model.Bike;
import pl.piotr.skoczylas.vehiclerental.repository.BikeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    @Autowired
    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    private void updateByNumber(Bike bike) {
        this.bikeRepository.getOne(bike.getId());
    }

    public Bike createNumber(Long number) {
        Bike bikeWithGivenNumber = bikeRepository.getByNumber(number);
        if (bikeWithGivenNumber != null) {
            this.updateByNumber(bikeWithGivenNumber);
            return bikeWithGivenNumber;
        }
        return bikeRepository.save(new Bike(number));
    }
}
