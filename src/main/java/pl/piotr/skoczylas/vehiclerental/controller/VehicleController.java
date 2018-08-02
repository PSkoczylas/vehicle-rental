package pl.piotr.skoczylas.vehiclerental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.piotr.skoczylas.vehiclerental.dao.VehicleDao;
import pl.piotr.skoczylas.vehiclerental.dto.BorrowDto;
import pl.piotr.skoczylas.vehiclerental.dto.VehicleDto;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;
import pl.piotr.skoczylas.vehiclerental.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/vehicles")
@ResponseStatus(HttpStatus.OK)
public class VehicleController {
    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET, produces = "application/json")
    public VehicleDto getVehicle(@PathVariable("id") long id) {
        return vehicleService.getVehicle(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<VehicleDto> getVehicles() {
        return vehicleService.getAllVehicles();
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeVehicle(@PathVariable Long id) {
        vehicleService.removeVehicle(id);
    }

    @PostMapping(value = "/borrow")
    @ResponseStatus(HttpStatus.OK)
    public void borrow(BorrowDto borrowDto) {
        vehicleService.borrow(borrowDto);
    }
}
