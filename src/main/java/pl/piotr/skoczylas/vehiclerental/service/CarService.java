package pl.piotr.skoczylas.vehiclerental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piotr.skoczylas.vehiclerental.asm.CarAsm;
import pl.piotr.skoczylas.vehiclerental.asm.EditCarAsm;
import pl.piotr.skoczylas.vehiclerental.dto.CarDto;
import pl.piotr.skoczylas.vehiclerental.dto.EditCarDto;
import pl.piotr.skoczylas.vehiclerental.exception.NotFoundException;
import pl.piotr.skoczylas.vehiclerental.model.Car;
import pl.piotr.skoczylas.vehiclerental.model.Manufacturer;
import pl.piotr.skoczylas.vehiclerental.repository.CarRepository;
import pl.piotr.skoczylas.vehiclerental.repository.ManufacturerRepository;

import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public CarService(CarRepository carRepository, ManufacturerRepository manufacturerRepository) {
        this.carRepository = carRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    public CarDto add(CarDto carDto) {
        Car car = CarAsm.makeCar(carDto);
        carRepository.save(applyManufacturer(carDto.getName(), car));
        return carDto;
    }

    private Car applyManufacturer(String name, Car car) {
        Manufacturer manufacturer = manufacturerRepository.findByName(name);
        if (manufacturer == null) {
            manufacturer = Manufacturer.builder().name(name).build();
            manufacturerRepository.save(manufacturer);
        }
        car.setManufacturer(manufacturer);
        return car;
    }

    public EditCarDto editCar(Long id, EditCarDto editCarDto) {
        Car car = getCarOrException(id);
        return EditCarAsm.editCarAsm(editCarDto, car);
    }

    private Car getCarOrException(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return  car.orElseThrow(() -> new NotFoundException("Car with given ID doesn't exist"));
    }
}
