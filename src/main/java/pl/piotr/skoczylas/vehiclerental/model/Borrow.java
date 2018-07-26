package pl.piotr.skoczylas.vehiclerental.model;

import lombok.*;
import pl.piotr.skoczylas.vehiclerental.constant.ConvertLocalDateToSQLDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Convert(converter = ConvertLocalDateToSQLDate.class)
    private LocalDate date;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Vehicle vehicle;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Borrower borrower;
}
