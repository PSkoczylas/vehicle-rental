package pl.piotr.skoczylas.vehiclerental.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.piotr.skoczylas.vehiclerental.model.Bike;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;
import pl.piotr.skoczylas.vehiclerental.repository.BikeRepository;
import pl.piotr.skoczylas.vehiclerental.service.BikeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class BikeDAO {
    private static List<Bike> bikes;

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private BikeService bikeService;

    public BikeDAO() {
        bikes = new ArrayList();
        bikes.add(new Bike(1L, LocalDate.of(1999,2,22), 5L));
        bikes.add(new Bike(2L, LocalDate.of(1991,11,14), 321L));
    }

    public List getAllList() { return bikes; }

    public Bike getBike(Long id) {
        for (Bike b: bikes) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public Bike create(Bike bike) {
        return bikeRepository.save(bike);
    }

    public Bike createNumber(Long number) {
        Bike bikeWithGivenNumber = bikeRepository.getByNumber(number);

        if (bikeWithGivenNumber != null) {
            bikeService.updateByNumber(bikeWithGivenNumber);

            return bikeWithGivenNumber;
        }
        return bikeRepository.save(new Bike(number));
    }
}
