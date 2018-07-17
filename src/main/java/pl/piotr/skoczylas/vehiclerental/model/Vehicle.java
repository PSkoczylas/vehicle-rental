package pl.piotr.skoczylas.vehiclerental.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.piotr.skoczylas.vehiclerental.constant.ConvertLocalDateToSQLDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dType")
public abstract class Vehicle {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private long id;
    @Column(insertable = false, updatable = false) private String dType;
    // jeszcze nazwa wypozyczajacego

    @Column(nullable = false)
    @Convert(converter = ConvertLocalDateToSQLDate.class)
    LocalDate borrow_date;

}
