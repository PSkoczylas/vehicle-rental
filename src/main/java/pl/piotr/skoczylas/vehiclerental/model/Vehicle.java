package pl.piotr.skoczylas.vehiclerental.model;

import lombok.*;
import pl.piotr.skoczylas.vehiclerental.constant.ConvertLocalDateToSQLDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dType")
public abstract class Vehicle {
    // poczytac o SEQUENCE I IDENTITY i innych strategiach
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(insertable = false, updatable = false)
    private String dType;
    // jeszcze nazwa wypozyczajacego

    @OneToMany(mappedBy = "vehicle")
    private List<Borrow> borrow = new ArrayList<>();
}
