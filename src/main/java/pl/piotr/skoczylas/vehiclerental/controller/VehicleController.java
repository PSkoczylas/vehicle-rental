package pl.piotr.skoczylas.vehiclerental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.piotr.skoczylas.vehiclerental.dao.VehicleDAO;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;
import pl.piotr.skoczylas.vehiclerental.repository.VehicleRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/vehicles")
@ResponseStatus(HttpStatus.OK)
public class VehicleController {
    @Autowired
    private VehicleDAO vehicleDAO;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET, produces = "application/json")
    public Vehicle getVehicle(@PathVariable("id") long id) {
        return vehicleDAO.getVehicle(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Vehicle> getVehicles() {
        return vehicleDAO.getAllList();
    }


}
