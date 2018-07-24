package pl.piotr.skoczylas.vehiclerental.model;

import lombok.*;
import pl.piotr.skoczylas.vehiclerental.constant.ConvertLocalDateToSQLDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
    private LocalDate borrowDate;

}
