package pl.piotr.skoczylas.vehiclerental.model;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class Bike extends Vehicle {
    @Column(unique = true)
    private Long number;

    private void setValues(Long number) {
        setNumber(number);
        //setDType("Bike");
    }

    public Bike(Long id, Long number) {
        setId(id);
        setValues(number);
    }

    public Bike(Long number) {
        setValues(number);
    }

}
