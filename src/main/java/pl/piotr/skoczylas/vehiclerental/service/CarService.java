package pl.piotr.skoczylas.vehiclerental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piotr.skoczylas.vehiclerental.asm.CarAsm;
import pl.piotr.skoczylas.vehiclerental.dto.CarDto;
import pl.piotr.skoczylas.vehiclerental.model.Car;
import pl.piotr.skoczylas.vehiclerental.repository.CarRepository;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarDto add(CarDto carDto) {
        Car car = CarAsm.makeCar(carDto);
        carRepository.save(car);
        return carDto;
    }
}
