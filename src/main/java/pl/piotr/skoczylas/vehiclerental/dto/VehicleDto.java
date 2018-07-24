package pl.piotr.skoczylas.vehiclerental.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class VehicleDto {
    private LocalDate borrowDate;
}
