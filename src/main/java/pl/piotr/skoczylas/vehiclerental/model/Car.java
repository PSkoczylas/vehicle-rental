package pl.piotr.skoczylas.vehiclerental.model;

import lombok.*;
import pl.piotr.skoczylas.vehiclerental.constant.Color;
import pl.piotr.skoczylas.vehiclerental.constant.ConvertLocalDateToSQLDate;
import pl.piotr.skoczylas.vehiclerental.service.CarService;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Car extends Vehicle {
    private String name;

    @ManyToOne
    private Manufacturer manufacturer;

    @NotNull
    @Convert(converter = ConvertLocalDateToSQLDate.class)
    private LocalDate productionDate;

    @NotNull
    @Enumerated
    private Color color;

    public Car(Long id, LocalDate productionDate, Color myColor) {
        setId(id);
        setProductionDate(productionDate);
        this.productionDate = productionDate;
        this.color = myColor;
        Borrow borrow = new Borrow();
        //borrow.setDate(borrowDate);
        //borrow.set
        //setBorrows(getBorrows().add());
        //setDType("Car");
    }

}
