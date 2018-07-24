package pl.piotr.skoczylas.vehiclerental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piotr.skoczylas.vehiclerental.dao.BikeDao;
import pl.piotr.skoczylas.vehiclerental.model.Bike;

@RestController
@RequestMapping(value = "/api/bikes")
@ResponseStatus(HttpStatus.OK)
public class BikeController {
    @Autowired
    private BikeDao bikeDao;

    @PostMapping(value = "/add/{number}")
    public ResponseEntity createBike(@PathVariable Long number) {
        Bike bike = bikeDao.createNumber(number);
        return new ResponseEntity<Bike>(bike, HttpStatus.OK);
    }
    // public bikeDTO
    // return serwis, ktore zwraca dto

}
