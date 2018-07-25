package pl.piotr.skoczylas.vehiclerental.asm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.piotr.skoczylas.vehiclerental.dto.CarDto;
import pl.piotr.skoczylas.vehiclerental.model.Car;
import pl.piotr.skoczylas.vehiclerental.model.Manufacturer;
import pl.piotr.skoczylas.vehiclerental.repository.ManufacturerRepository;

@Component
public class CarAsm {
    @Autowired
    static ManufacturerRepository manufacturerRepository;

    public static Car makeCar(CarDto carDto) {
        Car car = Car.builder()
                .name(carDto.getName())
                .color(carDto.getColor())
                .manufacturer(Manufacturer.builder().name(carDto.getManufacturer()).build())
                .productionDate(carDto.getProductionDate())
                .build();

        car.setBorrowDate(carDto.getBorrowDate());

        return car;
    }

    private static Manufacturer findOrCreateManufacture(String name) {
        Manufacturer manufacturer = manufacturerRepository.findByName(name);
    }
}
