package pl.piotr.skoczylas.vehiclerental.dto;

import lombok.*;
import pl.piotr.skoczylas.vehiclerental.constant.Color;
import pl.piotr.skoczylas.vehiclerental.constant.ConvertLocalDateToSQLDate;

import javax.persistence.Convert;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CarDto extends VehicleDto {
    private String name;

    private Color color;

    private String producerName;

    private LocalDate productionDate;
}
