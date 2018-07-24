package pl.piotr.skoczylas.vehiclerental.dao;

import org.springframework.stereotype.Component;
import pl.piotr.skoczylas.vehiclerental.model.Car;

import java.util.List;

@Component
public class CarDao {
    private static List<Car> vehicles;
}
