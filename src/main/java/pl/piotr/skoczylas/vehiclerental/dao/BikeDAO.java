package pl.piotr.skoczylas.vehiclerental.dao;

import org.springframework.stereotype.Component;
import pl.piotr.skoczylas.vehiclerental.model.Bike;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class BikeDAO {
    private static List<Bike> bikes;

    public BikeDAO() {
        bikes = new ArrayList();
        bikes.add(new Bike(1L, LocalDate.of(1999,2,22), 5L));
        bikes.add(new Bike(2L, LocalDate.of(1991,11,14), 321L));
        bikes.add(new Bike(3L, LocalDate.of(2015,2,22), 22L));
    }
}
