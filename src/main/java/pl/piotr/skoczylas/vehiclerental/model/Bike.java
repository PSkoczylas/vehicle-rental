package pl.piotr.skoczylas.vehiclerental.model;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bike extends Vehicle {
    @Column(unique = true)
    private Long number;

    private void setValues(Long number, LocalDate localDate) {
        setNumber(number);
        setBorrowDate(localDate);
        setDType("Bike");
    }

    public Bike(Long id, LocalDate borrowDate, Long number) {
        setId(id);
        setValues(number, borrowDate);
    }

    public Bike(Long number) {
        setValues(number, LocalDate.now());
    }

}
