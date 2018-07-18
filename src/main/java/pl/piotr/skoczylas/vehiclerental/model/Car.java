package pl.piotr.skoczylas.vehiclerental.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.piotr.skoczylas.vehiclerental.constant.Color;
import pl.piotr.skoczylas.vehiclerental.constant.ConvertLocalDateToSQLDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Car extends Vehicle {
    String name;

    String producerName;

    @Column(nullable = false)
    @Convert(converter = ConvertLocalDateToSQLDate.class)
    LocalDate productionDate;

    @Column(nullable = false)
    @Enumerated
    Color myColor;

    public Car(Long id, LocalDate productionDate, Color myColor, LocalDate borrowDate) {
        setId(id);
        setProductionDate(productionDate);
        setProducerName(producerName);
        setMyColor(myColor);
        setBorrowDate(borrowDate);
    }


}
