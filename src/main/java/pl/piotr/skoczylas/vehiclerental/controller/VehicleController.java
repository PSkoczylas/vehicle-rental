package pl.piotr.skoczylas.vehiclerental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;
import pl.piotr.skoczylas.vehiclerental.repository.VehicleRepository;

@RestController
@RequestMapping(value = "/api/vehicles")
@ResponseStatus(HttpStatus.OK)
public class VehicleController {
    @Autowired
    VehicleRepository vehicleRepository;

    @RequestMapping(value = "/details/:id", method = RequestMethod.GET, produces = "application/json")
    //@GetMapping(value = "/{id}")
    public Vehicle getVehicle(@PathVariable("id") long id) {
        return vehicleRepository.getOne(id);
    }


}
