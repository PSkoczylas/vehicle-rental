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
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Borrow borrow;

    private String firstName;
    private String lastName;
}
