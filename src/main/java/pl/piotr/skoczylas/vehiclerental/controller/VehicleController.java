package pl.piotr.skoczylas.vehiclerental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.piotr.skoczylas.vehiclerental.dao.VehicleDao;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;

import java.util.List;

@RestController
@RequestMapping(value = "/api/vehicles")
@ResponseStatus(HttpStatus.OK)
public class VehicleController {
    @Autowired
    private VehicleDao vehicleDao;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET, produces = "application/json")
    public Vehicle getVehicle(@PathVariable("id") long id) {
        return vehicleDao.getVehicle(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Vehicle> getVehicles() {
        return vehicleDao.getAllList();
    }

}
