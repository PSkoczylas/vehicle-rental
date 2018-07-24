package pl.piotr.skoczylas.vehiclerental.model;

import lombok.*;
import pl.piotr.skoczylas.vehiclerental.constant.Color;
import pl.piotr.skoczylas.vehiclerental.constant.ConvertLocalDateToSQLDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(callSuper = true)
public class Car extends Vehicle {
    private String name;

    private String producerName;

    @NotNull
    @Convert(converter = ConvertLocalDateToSQLDate.class)
    private LocalDate productionDate;

    @NotNull
    @Enumerated
    private Color color;

    public Car(Long id, LocalDate productionDate, Color myColor, LocalDate borrowDate) {
        setId(id);
        setProductionDate(productionDate);
        this.productionDate = productionDate;
        this.color = myColor;
        setBorrowDate(borrowDate);
        setDType("Car");
    }


}
