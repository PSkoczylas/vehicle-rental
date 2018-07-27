package pl.piotr.skoczylas.vehiclerental.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.piotr.skoczylas.vehiclerental.constant.Color;
import pl.piotr.skoczylas.vehiclerental.model.Car;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;
import pl.piotr.skoczylas.vehiclerental.repository.VehicleRepository;

import javax.xml.bind.SchemaOutputResolver;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleDao {

    private static List<Vehicle> vehicles;

    public VehicleDao() {
        vehicles = new ArrayList();
        vehicles.add(new Car(1L, LocalDate.of(2012, 12, 1), Color.BLUE));
        vehicles.add(new Car(2L, LocalDate.of(2011, 12, 1), Color.RED));
    }

    public List getAllList() {
        return vehicles;
    }

    public Vehicle getVehicle(Long id) {
        for (Vehicle v: vehicles) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
}
