package pl.piotr.skoczylas.vehiclerental.asm;

import org.apache.tomcat.jni.Local;
import pl.piotr.skoczylas.vehiclerental.constant.Color;
import pl.piotr.skoczylas.vehiclerental.dto.EditCarDto;
import pl.piotr.skoczylas.vehiclerental.model.Car;

public class EditCarAsm {
    public static EditCarDto editCarAsm(EditCarDto editCarDto, Car car) {
        editName(editCarDto, car);
        editColor(editCarDto, car);
        return editCarDto;
    }

    private static void editName(EditCarDto editCarDto, Car car) {
        String name = editCarDto.getName();
        if (name != null) {
            car.setName(name);
        } else {
            editCarDto.setName(car.getName());
        }
    }

    private static void editColor(EditCarDto editCarDto, Car car) {
        Color color = editCarDto.getColor();
        if (color != null) {
            car.setColor(color);
        } else {
            editCarDto.setColor(car.getColor());
        }
    }
}
