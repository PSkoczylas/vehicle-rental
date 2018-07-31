package pl.piotr.skoczylas.vehiclerental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.piotr.skoczylas.vehiclerental.dao.CarDao;
import pl.piotr.skoczylas.vehiclerental.dto.CarDto;
import pl.piotr.skoczylas.vehiclerental.dto.EditCarDto;
import pl.piotr.skoczylas.vehiclerental.service.CarService;

@RestController
@RequestMapping(value = "/api/cars")
@ResponseStatus(HttpStatus.OK)
public class CarController {
    @Autowired
    protected CarService carService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public CarDto add(@RequestBody CarDto carDto) {
        return carService.add(carDto);
    }


    @PostMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EditCarDto edit(@PathVariable EditCarDto editCarDto) {
        return carService.editCar(editCarDto);
    }
}
