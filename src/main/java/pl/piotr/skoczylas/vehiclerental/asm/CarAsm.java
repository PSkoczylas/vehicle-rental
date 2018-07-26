package pl.piotr.skoczylas.vehiclerental.asm;

import pl.piotr.skoczylas.vehiclerental.dto.CarDto;
import pl.piotr.skoczylas.vehiclerental.model.Car;

public class CarAsm {

    public static Car makeCar(CarDto carDto) {
        Car car = Car.builder()
                .name(carDto.getName())
                .color(carDto.getColor())
                .productionDate(carDto.getProductionDate())
                .build();

        car.setBorrowDate(carDto.getBorrowDate());

        return car;
    }
}
