package pl.piotr.skoczylas.vehiclerental.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class Bike extends Vehicle {
    @Column(unique = true)
    Long number;
}
